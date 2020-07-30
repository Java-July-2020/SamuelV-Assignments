package com.samuelvaldes.displaydate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HomeController {
	@RequestMapping("/")
    public String index() { 
		return "index.jsp";
    }
	
	@RequestMapping("/date")
    public String date(Model model) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, YYYY", Locale.ENGLISH);
		model.addAttribute("date",formatter.format(date));
		return "date.jsp";
    }
	
	@RequestMapping("/time")
    public String time(Model model) {
		Date time = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
		model.addAttribute("time",formatter.format(time));
		return "time.jsp";
    }
	
}