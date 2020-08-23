package com.samuelvaldes.authentication.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.samuelvaldes.authentication.models.User;
import com.samuelvaldes.authentication.repositories.UserRepository;

@Service
public class AppService {

	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------	
	
	private final UserRepository uRepository;
	
	public AppService(UserRepository uRepository) {
		this.uRepository = uRepository;

	}
	
	// ------------------------------------------------
	// II) CRUD methods for Controller class 
	// ------------------------------------------------
	
	// i) CREATE METHODS
	
	// Register a user and hash their password
	public User registerUser(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        return uRepository.save(user);
    }
	
	// ii) READ METHODS
	
	// Find user by email
	public User getUserByEmail(String email) {
		return uRepository.findByEmail(email);
	}
	
	// Find user by ID
	public User getUserById(Long id) {
		return this.uRepository.findById(id).orElse(null);
	}
	
	// ------------------------------------------------
	// III) Authentication methods
	// ------------------------------------------------
	
	// authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = this.getUserByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
