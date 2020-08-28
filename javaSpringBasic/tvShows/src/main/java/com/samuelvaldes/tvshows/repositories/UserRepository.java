package com.samuelvaldes.tvshows.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samuelvaldes.tvshows.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	// retrieves all events from database
	List<User> findAll();
	// retrieves a User by email from database
	Optional <User> findByEmail(String email);
}
