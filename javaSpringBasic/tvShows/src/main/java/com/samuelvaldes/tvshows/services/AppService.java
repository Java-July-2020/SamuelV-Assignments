package com.samuelvaldes.tvshows.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuelvaldes.tvshows.models.Rating;
import com.samuelvaldes.tvshows.models.Show;
import com.samuelvaldes.tvshows.models.User;
import com.samuelvaldes.tvshows.repositories.RatingRepository;
import com.samuelvaldes.tvshows.repositories.ShowRepository;
import com.samuelvaldes.tvshows.repositories.UserRepository;

@Service
public class AppService {

	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------	
	
	@Autowired
	private UserRepository uRepository;
		
	@Autowired
	private ShowRepository sRepository;
	
	@Autowired
	private RatingRepository rRepository;
	
	// ------------------------------------------------
	// II) CRUD methods for Controller class 
	// ------------------------------------------------
	
	// i) CREATE METHODS
	
	// Register a user
	public User registerUser(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        return this.uRepository.save(user);
    }
	
	// Create an event
	public Show createShow(Show show) {
        return this.sRepository.save(show);
    }
	
	// Create new message
	public void addRatingToShow(User rater, Show show, Double score) {
		Rating rating = new Rating(rater, show, score);
		this.rRepository.save(rating);
    }
	
	// ii) READ METHODS
	
	// Retrieves an user by ID
	public User getUserById(Long id) {
		return this.uRepository.findById(id).orElse(null);
	}
	
	// Retrieves an  user by email
	public User getUserByEmail(String email) {
		return this.uRepository.findByEmail(email).orElse(null);
	}
	
	// Retrieves all shows in database
	public List<Show> getAllShows() {
		return this.sRepository.findAll();
	}
	
	// Retrieves a show by ID
	public Show getShowById(Long id) {
		return this.sRepository.findById(id).orElse(null);
	}
	
	// Retrieves all ratings of a show by Descending order
	public List<Rating> getShowRatingsByRatingByAscOrder(Show show) {
		return this.rRepository.findByShowRatedOrderByScoreAsc(show);
	}
	
	// iii) UPDATE METHODS
	
	// Add user to an event
	public void addRaterToShow(User rater, Show show) {
		show.getUsersAlreadyRate().add(rater);
		this.sRepository.save(show);
	}
	
	// Edit a show
	public void editShow(Show show) {
        this.sRepository.save(show);
    }
	
	// iv) DELETE METHODS
	
	// Deletes a question by id
	public void deleteShowById(Long id) {
		this.sRepository.deleteById(id);
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
