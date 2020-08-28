package com.samuelvaldes.tvshows.validatiors;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.samuelvaldes.tvshows.models.User;

@Component
public class UserValidator {

	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            
            errors.rejectValue("passwordConfirmation", "Match Error", "Passwords do not match!");
        }         
    }
	
}
