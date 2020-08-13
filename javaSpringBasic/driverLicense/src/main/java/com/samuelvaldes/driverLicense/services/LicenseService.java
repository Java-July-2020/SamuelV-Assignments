package com.samuelvaldes.driverLicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samuelvaldes.driverLicense.models.License;
import com.samuelvaldes.driverLicense.repositories.LicenseRepository;

@Service
public class LicenseService {
	
	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------
	
	// Repository Attribute
	private final LicenseRepository licenseRepository;
	
	// Repository Constructor
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	// ------------------------------------------------
	// II) CRUD methods for Controller class 
	// ------------------------------------------------
	
	
	// Find all licenses
	
	public List<License> allLicenses(){
		return licenseRepository.findAll();
	}
	
	// Creates a license
	public License createLicense(License license) {
		license.setLicenseNumber(this.generateLicenseNumber());
		return this.licenseRepository.save(license);
	}
	
	// ------------------------------------------------
	// III) Auxiliar method
	// ------------------------------------------------
	
	public String generateLicenseNumber() {
		License license = licenseRepository.findTopByOrderByLicenseNumberDesc();
		if(license == null)
			return "000001";
		else{
			int newLicenseNumberUnformatted = Integer.parseInt(license.getLicenseNumber());
			newLicenseNumberUnformatted++;
			
			int numOfZeros = 6-String.valueOf(newLicenseNumberUnformatted).length();
			
			String newLicenseNumber = Integer.toString(newLicenseNumberUnformatted);
			
			for (int i = 0; i < numOfZeros; i++) {
				newLicenseNumber = "0" + newLicenseNumber;
			}
			
			return newLicenseNumber;
		}
	}
	
}
