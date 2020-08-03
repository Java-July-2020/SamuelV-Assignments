package com.samuelvaldes.ninjagold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	
	@RequestMapping("/")
    public String index(HttpSession session) {
		
		
		if(session.getAttribute("amountOfGold") == null) {
			System.out.println("hey");
			session.setAttribute("amountOfGold", 0);
		}
		if(session.getAttribute("activityLog") == null) {
			ArrayList<String> activityLog = new ArrayList<String>();
			session.setAttribute("activityLog", activityLog);
		}
		
		return "index.jsp";
	}
	
	@RequestMapping(path="/process_money", method=RequestMethod.POST)
    public String processMoney(HttpSession session, @RequestParam(value="place", required=false) String place) {
		
		// I) INITIALIZATION OF SOME VARIABLES
		
		// Variables for processing amount o Gold
		int amountOfGold = (int) session.getAttribute("amountOfGold");
		Random rand = new Random();
		
		// Variable for processing date 
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd YYYY h:mma");
		
		// Variable for processing log activity
		ArrayList<String> activityLog = (ArrayList<String>) session.getAttribute("activityLog");
		

		// II) PROCESSING THE MONEY
		
		// Farm Selected
		if(place.equals("farm")){	
			int farmGold = rand.nextInt((20 - 10) + 1) + 10;
			amountOfGold += farmGold;
			session.setAttribute("amountOfGold", amountOfGold);
			activityLog.add("You entered a farm and earned " + farmGold + " gold! " + "(" + formatter.format(now) + ")");
		}
		
		// Cave Selected
		if(place.equals("cave")) {
			int caveGold = rand.nextInt((10 - 5) + 1) + 5;
			amountOfGold += caveGold;
			session.setAttribute("amountOfGold", amountOfGold);
			activityLog.add("You entered a cave and earned " + caveGold + " gold! " + "(" + formatter.format(now) + ")");			
		}
		
		// House Selected
		if(place.equals("house")){
			int houseGold = rand.nextInt((5 - 2) + 1) + 2;
			amountOfGold += houseGold;
			session.setAttribute("amountOfGold", amountOfGold);
			activityLog.add("You entered a cave and earned " + houseGold + " gold! " + "(" + formatter.format(now) + ")");			
		}
		
		// Casino Selected
		if(place.equals("casino")){
			int casinoGold = rand.nextInt((50 + 50) + 1) - 50;
			amountOfGold += casinoGold;
			session.setAttribute("amountOfGold", amountOfGold);
			if(casinoGold > 0) {
				activityLog.add("You entered a casino and earned " + casinoGold + " gold! " + "(" + formatter.format(now) + ")");			
			}
			else {
				activityLog.add("You entered a casino and lost " + Math.abs(casinoGold) + " gold! Ouch!!!!! " + "(" + formatter.format(now) + ")");
			}
				
		}
		
		
		return "redirect:/";
	}
	
	
	@RequestMapping("/reset")
    public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
