package com.samuelvaldes.driverLicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samuelvaldes.driverLicense.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	// this method retrieves all the songs from the database
    List<Person> findAll();
}
