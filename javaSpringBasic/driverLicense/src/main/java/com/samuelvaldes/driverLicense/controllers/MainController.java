package com.samuelvaldes.driverLicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.samuelvaldes.driverLicense.models.License;
import com.samuelvaldes.driverLicense.models.Person;
import com.samuelvaldes.driverLicense.services.LicenseService;
import com.samuelvaldes.driverLicense.services.PersonService;



@Controller
public class MainController {

	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------
	
	private final PersonService personService;
	private final LicenseService licenseService;
	
	
	public MainController (PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	
	// ------------------------------------------------
	// II) Path Request Methods
	// ------------------------------------------------
	
	// GET Request to present Index and all Persons in the database
	@RequestMapping("/dashboard")
	public String index(Model model) {
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("persons", persons);
		return "index.jsp";
	}
	
	
	// GET Request to present form for adding new person
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}
	
	// POST Request for adding a new Person to the database
	@RequestMapping(value = "/persons/new", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newPerson.jsp";
		}
		else {
			personService.createPerson(person);
			return "redirect:/dashboard";
		}
	}
	
	// GET Request to present form for adding new license
	@RequestMapping("/licenses/new")
	public String newLicense(Model model, @ModelAttribute("license") License license) {
		List<Person> persons = personService.getUnlicensedPersons();
		model.addAttribute("persons", persons);
		
		return "newLicense.jsp";
	}
	
	// POST Request to present form for adding new license
	@RequestMapping(value="/licenses/new", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "newLicense.jsp";
		}
		else {
			System.out.println("Hey");
			licenseService.createLicense(license);
			return "redirect:/dashboard";
		}
	}
	
	// GET Request showing the info of the person in detail
	@RequestMapping("/persons/{id}")
	public String ShowPerson(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", personService.findPersonById(id));
		return "showPerson.jsp";
	}
	
	
	
	
	
	
	// GET Request for deleting a person
	@RequestMapping("/persons/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
        return "redirect:/dashboard";
    }
	
	// ------------------------------------------------
	// III) Auxiliar method
	// ------------------------------------------------
}
