package com.samuelvaldes.driverLicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samuelvaldes.driverLicense.models.Person;
import com.samuelvaldes.driverLicense.repositories.PersonRepository;


@Service
public class PersonService {

	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------
	
	private final PersonRepository personRepository;
	
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
		
	}
	
	// ------------------------------------------------
	// II) CRUD methods for Controller class 
	// ------------------------------------------------
	
	// retrieves all persons with or without license
	public List<Person> getAllPersons() {
		return this.personRepository.findAll();
	}
	
	// retrieves only unlicensed persons
	public List<Person> getUnlicensedPersons() {
		return this.personRepository.findByLicenseIdIsNull();
	}
	
	// creates a person
	public Person createPerson(Person person) {
		return this.personRepository.save(person);
	}
	
	// retrieves a person by id
	public Person findPersonById(Long id) {
		return this.personRepository.findById(id).orElse(null);
	}
	
	// retrieves a person by id
	public void deletePerson(Long id) {
		this.personRepository.deleteById(id);
	}
}
