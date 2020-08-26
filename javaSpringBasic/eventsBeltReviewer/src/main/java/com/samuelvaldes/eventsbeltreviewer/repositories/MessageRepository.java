package com.samuelvaldes.eventsbeltreviewer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samuelvaldes.eventsbeltreviewer.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{

	// retrieves all messages from database
	List<Message> findAll();
}
