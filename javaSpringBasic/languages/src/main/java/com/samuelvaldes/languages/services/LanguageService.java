package com.samuelvaldes.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samuelvaldes.languages.models.Language;
import com.samuelvaldes.languages.repositories.LanguageRepository;



@Service
public class LanguageService {

	// I) Adding the language repository as a dependency (Attribute and Constructor for repository)
	
	private final LanguageRepository languageRepository;
		
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	// II) CRUD Methods on Service Layer
	
	
	// get all languages
	public List<Language> allLanguages(){
		return this.languageRepository.findAll();
	}
	
	// creates a languages
	public Language createLanguage(Language language) {
		return this.languageRepository.save(language);
	}
		
	// retrieves a languages
	public Language findLanguage(Long id) {
		Language language = this.languageRepository.findById(id).orElse(null);
		return language;
	}
		
	// delete languages
	public void deleteLanguage(Long id) {
		this.languageRepository.deleteById(id);
	}
		
	// update languages
	public Language updateLanguage(Language updatedLanguaged) {
		return this.languageRepository.save(updatedLanguaged);
	 }
	
}
