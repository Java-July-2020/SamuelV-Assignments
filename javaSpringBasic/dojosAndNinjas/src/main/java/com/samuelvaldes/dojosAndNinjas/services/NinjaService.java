package com.samuelvaldes.dojosAndNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samuelvaldes.dojosAndNinjas.models.Ninja;
import com.samuelvaldes.dojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------
	
	// Repository Attribute
	private final NinjaRepository ninjaRepository;
	
	// Repository Constructor
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	// ------------------------------------------------
	// II) CRUD methods for Controller class 
	// ------------------------------------------------
	
	
	// Retrieves all ninjas
	
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	
	// Creates a ninja
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepository.save(ninja);
	}
}
