package com.samuelvaldes.dojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.samuelvaldes.dojosAndNinjas.models.Dojo;
import com.samuelvaldes.dojosAndNinjas.models.Ninja;
import com.samuelvaldes.dojosAndNinjas.services.DojoService;
import com.samuelvaldes.dojosAndNinjas.services.NinjaService;

@Controller
public class MainController {

	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------
	
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	
	public MainController (DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	// ------------------------------------------------
	// II) Path Request Methods
	// ------------------------------------------------
	
	// 1) DASHBOARD REQUESTS
	
	// GET Request to present Index and all Dojos in the database
		@RequestMapping("/dashboard")
		public String index(Model model) {
			List<Dojo> dojos = dojoService.getAllDojos();
			model.addAttribute("dojos", dojos);
			return "index.jsp";
		}
	
	// 2) DOJO REQUESTS 
		
	// GET Request to present form for adding new dojo
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	// POST Request for adding a new dojo to the database
	@RequestMapping(value = "/dojos/new", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		else {
			dojoService.createDojo(dojo);
			return "redirect:/dashboard";
		}
	}
	
	// GET Request showing the info of a dojo in detail
	@RequestMapping("/dojos/{id}")
	public String ShowDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojoById(id));
		return "showDojo.jsp";
	}
	
	// GET Request for deleting a dojo
	@RequestMapping("/dojos/delete/{id}")
    public String deleteDojo(@PathVariable("id") Long id) {
        dojoService.deleteDojo(id);
        return "redirect:/dashboard";
    }
	
	// 3) NINJA REQUESTS 
	
	// GET Request to present form for adding new ninja
	@RequestMapping("/ninjas/new")
	public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojos = dojoService.getAllDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	
	// POST Request to present form for adding new ninja
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		}
		else {
			ninjaService.createNinja(ninja);
			return "redirect:/dashboard";
		}
	}
}
