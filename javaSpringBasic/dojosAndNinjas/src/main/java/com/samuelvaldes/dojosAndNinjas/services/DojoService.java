package com.samuelvaldes.dojosAndNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samuelvaldes.dojosAndNinjas.models.Dojo;
import com.samuelvaldes.dojosAndNinjas.repositories.DojoRepository;



@Service
public class DojoService {

	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------
	
	private final DojoRepository dojoRepository;
	
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
		
	}
	
	// ------------------------------------------------
	// II) CRUD methods for Controller class 
	// ------------------------------------------------
	
	// Retrieves all dojos
	public List<Dojo> getAllDojos() {
		return this.dojoRepository.findAll();
	}
	
	// Creates a dojo
	public Dojo createDojo(Dojo dojo) {
		return this.dojoRepository.save(dojo);
	}
	
	// Retrieves a dojo by id
	public Dojo findDojoById(Long id) {
		return this.dojoRepository.findById(id).orElse(null);
	}
	
	// Deletes a dojo by id
	public void deleteDojo(Long id) {
		this.dojoRepository.deleteById(id);
	}
}
