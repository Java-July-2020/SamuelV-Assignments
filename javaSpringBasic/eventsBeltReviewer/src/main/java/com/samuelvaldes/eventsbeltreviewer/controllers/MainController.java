package com.samuelvaldes.eventsbeltreviewer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.samuelvaldes.eventsbeltreviewer.models.Event;
import com.samuelvaldes.eventsbeltreviewer.models.State;
import com.samuelvaldes.eventsbeltreviewer.models.User;
import com.samuelvaldes.eventsbeltreviewer.services.AppService;

@Controller
public class MainController {
	
	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------
	
	@Autowired
	private AppService appService;
	
	// ------------------------------------------------
	// II) Path Request Methods
	// ------------------------------------------------

	// 1) EVENTS REQUESTS
	
	// GET Request to present eventsDashboard page with form for adding new events
	@GetMapping("/events")
    public String showEventsDashboard(@ModelAttribute("event") Event event, Model model, HttpSession session) {
        
		// If there is no attribute "user_id" on session, then redirect to index page
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}
		// Else render the page and pass all the necessary attributes to the eventsDashborb page and return it
		else {
			User currentUser = appService.getUserById(userId);
			String currentUserState = currentUser.getState();
			List<Event> eventsInUserState = appService.getEventByState(currentUserState);
			List<Event> eventsNotInUserState = appService.getEventByStateNotIn(currentUserState);
			
			model.addAttribute("user",currentUser);
			model.addAttribute("eventsInUserState",eventsInUserState);
			model.addAttribute("eventsNotInUserState",eventsNotInUserState);
			model.addAttribute("states", State.States);
			
			return "eventsDashboard.jsp";
		}
		
    }
	
	// POST Request for adding a new event to the database
	@PostMapping("/events/new")
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) {
		
		if(result.hasErrors()) {
			
			Long userId = (Long) session.getAttribute("user_id");
			User currentUser = appService.getUserById(userId);
			String currentUserState = currentUser.getState();
			List<Event> eventsInUserState = appService.getEventByState(currentUserState);
			List<Event> eventsNotInUserState = appService.getEventByStateNotIn(currentUserState);
			
			model.addAttribute("user",currentUser);
			model.addAttribute("eventsInUserState",eventsInUserState);
			model.addAttribute("eventsNotInUserState",eventsNotInUserState);
			model.addAttribute("states", State.States);
			
			return "eventsDashboard.jsp";
		}
		else {
			appService.createEvent(event);
			return "redirect:/events";
		}
	}
	
	// GET Request for Joining or Canceling for an event
	@GetMapping("/events/{id}/attendee/{choice}")
	public String manageAttendance(@PathVariable("id") Long id, @PathVariable("choice") String choice, HttpSession session) {
		
		Long userId = (Long) session.getAttribute("user_id");
		User currentUser = appService.getUserById(userId);
		Event eventSelected = appService.getEventById(id);
		
		// Check if userId is null. If it is then redirect to login page
		if (userId == null) {
			return "redirect:/";
		}
		
		// If userId is not null, then join or cancel to the event depending the choice
		else {
			
			// If the user choose "join", then add user to event
			if(choice.equals("join")){
				appService.addUserToEvent(currentUser, eventSelected);
			}
			// If the user choose "cancel", then remove user from event
			else {
				appService.removeUserFromEvent(currentUser, eventSelected);
			}	
			
			return "redirect:/events";
		}
	}
	
	// GET Request for showing details from an event
	@GetMapping("/events/{id}")
    public String showEventInformation(@ModelAttribute("error") String error, @PathVariable("id") Long id, Model model, HttpSession session) {
	
		Long userId = (Long) session.getAttribute("user_id");
		User currentUser = this.appService.getUserById(userId);
		Event eventSelected = this.appService.getEventById(id);
		
		// Check if userId is null. If it is then redirect to login page
		if(userId == null) {
			return "redirect:/";
		}
		// Else If the event selected is null then redirect to eventsDashboard page
		else if(eventSelected == null) {
			return "redirect:/events";
		}
		// Else, show the showEvent page
		else {
			model.addAttribute("user",currentUser);
			model.addAttribute("event", eventSelected);
			model.addAttribute("error", error);
			
		    return "showEvent.jsp";
		}
	
	}
	
	@PostMapping("/events/{id}/comment")
    public String commnetEvent(@PathVariable("id") Long id, @RequestParam("comment") String comment, RedirectAttributes redirs, HttpSession session) {
		
		Long userId = (Long) session.getAttribute("user_id");
		User currentUser = this.appService.getUserById(userId);
		Event eventSelected = this.appService.getEventById(id);
		
		// Check if userId is null. If it is then redirect to login page
		if(userId == null) {
			return "redirect:/";
		}
		// Else If the comment sent is empty then redirect to showEvent Page and render and error
		else if(comment.equals("")) {
			redirs.addAttribute("error","Comment must not be blank");
			return "redirect:/events/"+id;
		}
		// Else, add the comment to the Wall Message and redirect to ShowEventPage to render the page again
		else {
			this.appService.addCommentsToEvent(currentUser, eventSelected, comment);
			return "redirect:/events/"+id;
		}
		
	}

	// GET Request for showing form to edit an event
	@GetMapping("/events/{id}/edit")
    public String showEditEventForm(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		Long userId = (Long) session.getAttribute("user_id");
		User currentUser = this.appService.getUserById(userId);
		Event eventSelected = this.appService.getEventById(id);
		
		// Check if userId is null. If it is then redirect to login page
		if(userId == null) {
			return "redirect:/";
		}
		// Else If the event select is null or there is no planner for the event then redirect to eventsDashboard page
		else if(eventSelected == null || !eventSelected.getPlanner().getId().equals(userId)) {
			return "redirect:/events";
		}
		// Else show the editEvent page
		else {
			model.addAttribute("user",currentUser);
			model.addAttribute("event", eventSelected);
			model.addAttribute("states", State.States);
		    return "editEvent.jsp";
		}
    }
	
	// PUT Request for showing updating fields of given event
	@PutMapping("/events/{id}/edit")
    public String editEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, @PathVariable("id") Long id, Model model, HttpSession session) {
		
		if(result.hasErrors()) {
			Long userId = (Long) session.getAttribute("user_id");
			User currentUser = this.appService.getUserById(userId);
			Event eventSelected = this.appService.getEventById(id);
			String error = "Error: Fields must not be empty and Dates have on the future!";
			
			model.addAttribute("user",currentUser);
			model.addAttribute("event", eventSelected);
			model.addAttribute("states", State.States);
			model.addAttribute("error", error);
			
	        return "editEvent.jsp";
		}
		
		else {
			this.appService.updateEvent(event);
			return "redirect:/events";
		}
		
    }
	
	// Delete Request for deleting an event
	@DeleteMapping("/events/{id}/delete")
    public String deleteEvent(@PathVariable("id") Long id) {
        this.appService.deleteEventById(id);
        return "redirect:/events";
    }

}
