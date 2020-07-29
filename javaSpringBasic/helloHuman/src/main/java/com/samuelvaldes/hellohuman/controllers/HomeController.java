package com.samuelvaldes.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
    public String index(Model model, @RequestParam(value="firstName",required=false, defaultValue="Human") String firstName, @RequestParam(value="lastName",required=false, defaultValue="") String lastName) {
		model.addAttribute("firstName",firstName);
		model.addAttribute("lastName",lastName);
		return "index.jsp";
    }
}
