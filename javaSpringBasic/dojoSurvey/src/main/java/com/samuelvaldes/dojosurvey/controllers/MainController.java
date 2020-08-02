package com.samuelvaldes.dojosurvey.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

	
	@RequestMapping("/")
    public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/result")
    public String result() {
		return "result.jsp";
	}
	
	@RequestMapping(path="/submit", method= RequestMethod.POST)
    public String submit(
    		@RequestParam(value="firstName", required=false) String firstName,
    		@RequestParam(value="lastName", required=false) String lastName,
    		@RequestParam(value="email", required=false) String email,
    		@RequestParam(value="birthday",required=false) String birthday,
    		@RequestParam(value="gender", required=false) String gender,
    		@RequestParam(value="comments", required=false) String comments,
    		@RequestParam(value="favoriteLanguage", required=false) String favoriteLanguage,
    		@RequestParam(value="frameworksAndLibraries", required=false) String[] frameworksAndLibrariesList,
    		RedirectAttributes redirectAttributes) {
		
		if(firstName == "") {
			firstName = "No first name submitted";
		}
		
		if(lastName == "") {
			lastName = "No last name submitted";
		}
		if(email == "") {
			email = "No email submitted";
		}
		
		if(birthday== "") {
			birthday = "No birthday submitted";
		}
		else {
	
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd'th', YYYY", Locale.ENGLISH);
			birthday = formatter.format(new Date());
		}
		
		if(gender == null) {
			gender = "No gender selected";
		}
		
		if(comments == "") {
			comments = "No comments added";
		}

		if(favoriteLanguage.equals("-1")) {
			favoriteLanguage = "No favorite language selected";
		}
		
		String frameworksAndLibraries = "";
		if(frameworksAndLibrariesList == null) {
			frameworksAndLibraries = "No framweroks and libraries selected";
		}
		else {
			for (String eachFramework : frameworksAndLibrariesList) {
				frameworksAndLibraries += eachFramework + ", "; 
			}
			frameworksAndLibraries = frameworksAndLibraries.substring(0,frameworksAndLibraries.length()-2);
		}
	

		
		redirectAttributes.addFlashAttribute("firstName", firstName);
		redirectAttributes.addFlashAttribute("lastName", lastName);
		redirectAttributes.addFlashAttribute("email", email);
		redirectAttributes.addFlashAttribute("birthday", birthday);
		redirectAttributes.addFlashAttribute("gender", gender);
		redirectAttributes.addFlashAttribute("comments", comments);
		redirectAttributes.addFlashAttribute("favoriteLanguage", favoriteLanguage);
		redirectAttributes.addFlashAttribute("frameworksAndLibraries", frameworksAndLibraries);
		
		return "redirect:/result";
	}
}
