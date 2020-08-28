package com.samuelvaldes.tvshows.validatiors;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.samuelvaldes.tvshows.models.Show;

@Component
public class ShowValidator {
	
	public boolean supports(Class<?> clazz) {
		return Show.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
        Show show = (Show) target;
        
        if (show.getName()==null) {
            
            errors.rejectValue("passwordConfirmation", "Match Error", "Passwords do not match!");
        }         
    }

}
