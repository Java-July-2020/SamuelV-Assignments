package com.samuelvaldes.driverLicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samuelvaldes.driverLicense.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
	// this method retrieves all the songs from the database
    List<License> findAll();

}
