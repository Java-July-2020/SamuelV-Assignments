package com.samuelvaldes.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samuelvaldes.dojooverflow.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

	// retrieves all answers from the database
    public List<Answer> findAll();
}
