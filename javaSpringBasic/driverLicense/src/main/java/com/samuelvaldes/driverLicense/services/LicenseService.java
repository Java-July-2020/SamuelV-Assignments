package com.samuelvaldes.driverLicense.services;

import org.springframework.stereotype.Service;

import com.samuelvaldes.driverLicense.models.License;
import com.samuelvaldes.driverLicense.repositories.LicenseRepository;

@Service
public class LicenseService {

	// adding the person repository as a dependency
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	// creates a license
	public License createLicense(License license) {
		return this.licenseRepository.save(license);
	}
	
	// retrieves a license by id
	public License findLicenseById(Long id) {
		return this.licenseRepository.findById(id).orElse(null);
	}
}
