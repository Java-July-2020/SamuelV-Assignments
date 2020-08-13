package com.samuelvaldes.driverLicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samuelvaldes.driverLicense.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{

	// retrieves all licenses from the database
    public List<License> findAll();
    
    // retrieves first license in the database
    public License findTopByOrderByLicenseNumberDesc();
}
