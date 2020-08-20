package com.samuelvaldes.dojooverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samuelvaldes.dojooverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

	// retrieves all tags from the database
    public List<Tag> findAll();
    
    // retrieves a tag from database which match a given subject
    public Optional <Tag> findBySubject(String subject);
}
