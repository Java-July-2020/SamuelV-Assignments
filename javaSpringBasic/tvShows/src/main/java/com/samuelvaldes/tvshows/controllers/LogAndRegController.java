package com.samuelvaldes.tvshows.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.samuelvaldes.tvshows.models.User;
import com.samuelvaldes.tvshows.services.AppService;
import com.samuelvaldes.tvshows.validatiors.UserValidator;

@Controller
public class LogAndRegController {
	
	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------
	
	@Autowired
	private AppService appService;
	
	@Autowired
	private UserValidator userValidator;
	
	// ------------------------------------------------
	// II) Path Request Methods
	// ------------------------------------------------

	// 1) REGISTER AND LOGIN REQUESTS
	
	// GET Request to present index page with form for log-in and registration for a user
	@GetMapping("/")
    public String showIndex(@ModelAttribute("user") User user, @ModelAttribute("error") String error, Model model) {
		return "index.jsp";
    }
	
	// POST Request for registering a new user to the database
	@PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
		
		// if result has errors, return the index page
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
    		return "index.jsp";
		}
    	// else, save the user in the database, save the user id in session, and redirect them to the /events route
		else {
			User newUser = this.appService.registerUser(user);
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/shows";
		}
    }
	
	// POST Request for logging in a new user
	@PostMapping("/login")
    public String loginUser(
    		@RequestParam("email") String email, 
    		@RequestParam("password") String password,
    		RedirectAttributes redirs,
    		HttpSession session) {
    	
    	// if the user is authenticated, save their user id in session
    	if(this.appService.authenticateUser(email, password)) {
    		User loggedInUser = this.appService.getUserByEmail(email);
    		session.setAttribute("user_id",loggedInUser.getId());
    		return "redirect:/shows";
    	}
    	// else, add error messages and return the login page
    	else {
    		redirs.addFlashAttribute("error", "Invalid credentials. Please try again!");
    		return "redirect:/";
    	}
    	
    }
	
	// 2) LOGOUT REQUESTS
	
	@GetMapping("/logout")
    public String logoutUser(HttpSession session) {
        // invalidate session
    	session.invalidate();
        // redirect to login page
    	return "redirect:/";
    }
	


}
