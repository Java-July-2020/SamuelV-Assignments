package com.samuelvaldes.tvshows.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.samuelvaldes.tvshows.models.Rating;
import com.samuelvaldes.tvshows.models.Show;
import com.samuelvaldes.tvshows.models.User;
import com.samuelvaldes.tvshows.services.AppService;


@Controller
public class ShowController {

	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------
	
	@Autowired
	private AppService appService;
	
	// ------------------------------------------------
	// II) Path Request Methods
	// ------------------------------------------------
	
	// 1) DASHBOARD REQUESTS
	
	// GET Request to present eventsDashboard page with form for adding new events
	@GetMapping("/shows")
    public String showTvShowsDashboard(Model model, HttpSession session) {
        
		// If there is no attribute "user_id" on session, then redirect to index page
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}
		// Else render the page and pass all the necessary attributes to the showsDashboarb page and return it
		else {
			User currentUser = this.appService.getUserById(userId);
			List <Show> allShows = this.appService.getAllShows();
			model.addAttribute("user",currentUser);
			model.addAttribute("shows",allShows);
			return "tvShowsDashboard.jsp";
		}
		
    }
	
	// 2) SHOWS REQUESTS
	
	// GET Request to present newShow page with form for adding a new TV show
	@GetMapping("/shows/new")
    public String showTvShowCreateForm(@ModelAttribute("show") Show show, Model model, HttpSession session) {
        
		Long userId = (Long) session.getAttribute("user_id");
				
		// If there is no attribute "user_id" on session, then redirect to index page
		if (userId == null) {
			return "redirect:/";
		}
		// Else render the page and pass all the necessary attributes to the newShow page and return it
		else {
			User currentUser = this.appService.getUserById(userId);
			model.addAttribute("user",currentUser);
			return "newTvShow.jsp";
		}
		
    }
	
	// POST Request for adding a new show to the database
	@PostMapping("/shows/new")
	public String createTvShow(@Valid @ModelAttribute("show") Show show, BindingResult result, Model model, HttpSession session) {
		
		if(result.hasErrors()) {
			
			Long userId = (Long) session.getAttribute("user_id");
			User currentUser = appService.getUserById(userId);
			
			model.addAttribute("user",currentUser);		
			return "newTvShow.jsp";
		}
		else {
			appService.createShow(show);
			return "redirect:/shows";
		}
	}
	
	// GET Request for showing details of a show
	@GetMapping("/shows/{id}")
    public String showEventInformation(@ModelAttribute("error") String error, @PathVariable("id") Long id, Model model, HttpSession session) {
	
		Long userId = (Long) session.getAttribute("user_id");
		Show showSelected = this.appService.getShowById(id);
				
		// Check if userId is null. If it is then redirect to login page
		if(userId == null) {
			return "redirect:/";
		}
		// Else If the show selected is null then redirect to showsDashboard page
		else if(showSelected == null) {
			return "redirect:/shows";
		}
		// Else, show the showTvShow page
		else {
			User currentUser = appService.getUserById(userId);
			List <Rating> ratingsofShowInDescOrder = appService.getShowRatingsByRatingByAscOrder(showSelected);
			
			model.addAttribute("user",currentUser);
			model.addAttribute("show",showSelected);
			model.addAttribute("ratingsofShowInDescOrder",ratingsofShowInDescOrder);
			model.addAttribute("error", error);
			return "showTvShow.jsp";
		}
	
	}
	
	// POST Request for adding a rate to a show
	@PostMapping("/shows/{id}/rate")
    public String addRatingToShow(@PathVariable("id") Long id, @RequestParam("rate") Double rate, RedirectAttributes redirs, HttpSession session) {
		
		Long userId = (Long) session.getAttribute("user_id");
		Show showSelected = this.appService.getShowById(id);
		User currentUser = this.appService.getUserById(userId);
		
		System.out.println(rate);
		
		// Check if userId is null. If it is then redirect to login page
		if(userId == null) {
			return "redirect:/";
		}
		// Else If the given rate is less than 1 or more than 5 then redirect to showTvShow Page and render and error
		else if(rate == null) {
			redirs.addFlashAttribute("error","Field cannot be empty");
			return "redirect:/shows/"+id;
		}	
		// Else If the given rate is less than 1 or more than 5 then redirect to showTvShow Page and render and error
		else if(rate<1 || rate>5) {
			redirs.addFlashAttribute("error","Rate must be between 1 and 5");
			return "redirect:/shows/"+id;
		}
		// Else, add the comment to the Wall Message and redirect to ShowEventPage to render the page again
		else {
			this.appService.addRatingToShow(currentUser, showSelected, rate);
			this.appService.addRaterToShow(currentUser, showSelected);
			return "redirect:/shows/"+id;
		}
		
	}
	
	// GET Request for showing form to edit a TV Show
	@GetMapping("/shows/{id}/edit")
    public String showEditTvShowForm(@ModelAttribute("show") Show show, @PathVariable("id") Long id, Model model, HttpSession session) {
		
		Long userId = (Long) session.getAttribute("user_id");
		Show showSelected = this.appService.getShowById(id);
		
		// Check if userId is null. If it is then redirect to login page
		if(userId == null) {
			return "redirect:/";
		}
		// Else If the show selected is null or the user is not the creator of the show then redirect to showsDashboard page
		
		else if(showSelected == null || !showSelected.getCreator().getId().equals(userId) ) {
			return "redirect:/shows";
		}
		// Else show the editTvShow page
		else {
			User currentUser = this.appService.getUserById(userId);
			model.addAttribute("user",currentUser);
			model.addAttribute("show",showSelected);
			return "editTvShow.jsp";
		}
    }
	
	// PUT Request for showing updating fields of given event
	@PutMapping("/shows/{id}/edit")
    public String editTvShow(@Valid @ModelAttribute("show") Show show, BindingResult result, @PathVariable("id") Long id, Model model, HttpSession session) {
				
		if(result.hasErrors()) {
			
			Long userId = (Long) session.getAttribute("user_id");
			User currentUser = this.appService.getUserById(userId);
			Show showSelected = this.appService.getShowById(id);
			String error = "Error: Fields must not be empty!";
						
			model.addAttribute("user",currentUser);
			model.addAttribute("show",showSelected);
			model.addAttribute("error", error);
			
	        return "editTvShow.jsp";
		}
		
		else {
			this.appService.editShow(show);
			return "redirect:/shows";
		}
		
    }
	
	// GET Request for deleting a TV show
	@GetMapping("/shows/{id}/delete")
    public String deleteShow(@PathVariable("id") Long id) {
        this.appService.deleteShowById(id);
        return "redirect:/shows";
    }
}
