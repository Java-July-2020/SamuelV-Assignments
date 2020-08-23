package com.samuelvaldes.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.samuelvaldes.authentication.models.User;
import com.samuelvaldes.authentication.services.AppService;

@Controller
public class MainController {
	
	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------
	
	private final AppService appService;
    
    public MainController (AppService appService) {
        this.appService = appService;
    }
    
    // ------------------------------------------------
 	// II) Path Request Methods
 	// ------------------------------------------------
    
    // 1) REGISTRATION REQUESTS

    // GET Request to present registration page and form to register a user
    @GetMapping("/registration")
    public String showRegistrationForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }

    // POST Request for registering a new user to the database
    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	
    	// if result has errors, return the registration page
    	if(result.hasErrors()) {
			return "registrationPage.jsp";
		}
    	// else, save the user in the database, save the user id in session, and redirect them to the /home route
		else {
			User newUser = appService.registerUser(user);
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/home";
		}
    }
    
    // 2) LOGIN REQUESTS
    
    // GET Request to present logging page and form to log-in a user
    @GetMapping("/login")
    public String showLoginForm(@ModelAttribute("user") User user) {
        return "loginPage.jsp";
    }
    
    @PostMapping("/login")
    public String loginUser(
    		@RequestParam("email") String email, 
    		@RequestParam("password") String password, 
    	 	Model model, 
    		HttpSession session) {
    	
    	// if the user is authenticated, save their user id in session
    	if(this.appService.authenticateUser(email, password)) {
    		User loggedInUser = this.appService.getUserByEmail(email);
    		session.setAttribute("user_id",loggedInUser.getId());
    		return "redirect:/home";
    	}
    	// else, add error messages and return the login page
    	else {
    		model.addAttribute("error", "Invalid credentials. Please try again!");
    		return "loginPage.jsp";
    	}
    	
    }
    
    // 3) HOME REQUESTS
    
    @GetMapping("/home")
    public String showHomePage(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long userId = (Long) session.getAttribute("user_id");
    	User user = appService.getUserById(userId);
    	model.addAttribute("user",user);
    	return "homePage.jsp";
    }
    
    // 4) LOGOUT REQUESTS
    
    @GetMapping("/logout")
    public String logoutUser(HttpSession session) {
        // invalidate session
    	session.invalidate();
        // redirect to login page
    	return "loginPage.jsp";
    }
}
