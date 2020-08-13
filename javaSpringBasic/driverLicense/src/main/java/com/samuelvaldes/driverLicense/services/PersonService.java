package com.samuelvaldes.driverLicense.services;

import org.springframework.stereotype.Service;

import com.samuelvaldes.driverLicense.models.Person;
import com.samuelvaldes.driverLicense.repositories.PersonRepository;


@Service
public class PersonService {

	// adding the person repository as a dependency
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	// creates a person
	public Person createPerson(Person person) {
		return this.personRepository.save(person);
	}
	
	// retrieves a person by id
	public Person findPersonById(Long id) {
		return this.personRepository.findById(id).orElse(null);
	}
}
