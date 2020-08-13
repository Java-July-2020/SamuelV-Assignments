package com.samuelvaldes.driverLicense.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samuelvaldes.driverLicense.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	
	// retrieves all the persons from the database
    public List<Person> findAll();
    
    @Query(value="SELECT p.* FROM persons p LEFT OUTER JOIN licenses l ON p.id = l.person_id WHERE l.id IS NULL", nativeQuery=true)
    public List<Person> findByNoLicense();
	
	public List<Person> findByLicenseIdIsNull();
}
