package com.samuelvaldes.eventsbeltreviewer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samuelvaldes.eventsbeltreviewer.models.Event;


@Repository
public interface EventRepository extends CrudRepository<Event, Long>{

	// retrieves all events from database
	List<Event> findAll();
	// retrieves all events in a specific state
	List <Event> findByState(String state);
	// retrieves all events not in a specific state
	List <Event> findByStateIsNot(String state);

}
