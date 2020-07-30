package com.samuelvaldes.counter.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
    public String index(HttpSession session) { 
		
		// if no key exists in session with the name "count", then set "count" to 0
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		
		// Else, retrieve the current value of count in session
		else {
		
			Integer currentCount = (Integer) session.getAttribute("count");
			// Increment count by 1
			currentCount++;
			// set the updated count value back into session
			session.setAttribute("count", currentCount);
		}
		
		return "index.jsp";
    }
	
	@RequestMapping("/counter")
    public String count(HttpSession session) {
		
		// if "/counter" is visited first or Session values are rested, then set "count" to 0
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}

		return "counter.jsp";
    }
	
	@RequestMapping("/reset")
    public String reset(HttpSession session) {
		
		// All variables in session are reseted
		session.invalidate();
		return "redirect:/counter";
    }
	
}