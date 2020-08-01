package com.samuelvaldes.thecode.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	String error_message;
	@RequestMapping("/")
    public String index(Model model) {
		model.addAttribute("errorMessage", error_message);
		return "index.jsp";
	}
	
	@RequestMapping("/code")
    public String code() { 
		return "code.jsp";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
    public String login(@RequestParam(value="password") String password) { 
	
		if (password.equals("bushido")) {
			error_message = "";
			return "redirect:/code";
		}
		
		else {
			error_message = "You must try harder!";
			return "redirect:/";
		}
		
	}

}
