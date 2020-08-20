package com.samuelvaldes.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samuelvaldes.dojooverflow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

	// retrieves all questions from the database
    public List<Question> findAll();
}
