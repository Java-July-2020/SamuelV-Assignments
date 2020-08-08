package com.samuelvaldes.languages.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.samuelvaldes.languages.models.Language;
import com.samuelvaldes.languages.services.LanguageService;

@Controller
public class MainController {

	// I) Attributes and Constructor for Controller
	
	private final LanguageService languageService;
		
	public MainController (LanguageService languageService) {
		System.out.println("hey");
		this.languageService = languageService;
	}

	// II) Show all languages method and Form for adding a new language
	
	@RequestMapping("/languages")
	public String showAllLanguages(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "languages.jsp";
	}
	

	// III) Find a specific language method
	
	@RequestMapping("/languages/{id}")
	public String findLanguage(Model model, @PathVariable("id") Long id) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "showLanguage.jsp";
	}	

	// IV) Create new language method
	
	// POST Request
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String createBook(Model model, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			List<Language> languages = languageService.allLanguages();
			model.addAttribute("languages", languages);
			return "languages.jsp";
		}
		else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	// V) Update a language methods (two methods, one with a GET and other with POST request)
	
	// GET Request
	@RequestMapping("/languages/edit/{id}")
	public String editLanguage(Model model, @PathVariable("id") Long id) {
		Language language = languageService.findLanguage(id);
		if (language != null) {
			model.addAttribute("language",language);
			return "editLanguage.jsp";
		}
		else {
			return "redirect:/languages";
		}
	}
	
	// POST Request
	@RequestMapping(value="/languages/edit/{id}", method=RequestMethod.POST)
	public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		
		if (result.hasErrors()) {
			return "editLanguage.jsp";
		}
		else {
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
		
	}
	
	// V) Delete a book methods
	
	
	// GET Request
	@RequestMapping("/languages/delete/{id}")
    public String deleteLanguage(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
		
}
