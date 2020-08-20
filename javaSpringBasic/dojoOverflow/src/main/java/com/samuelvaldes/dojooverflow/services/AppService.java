package com.samuelvaldes.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.samuelvaldes.dojooverflow.models.Answer;
import com.samuelvaldes.dojooverflow.models.Question;
import com.samuelvaldes.dojooverflow.models.Tag;
import com.samuelvaldes.dojooverflow.repositories.AnswerRepository;
import com.samuelvaldes.dojooverflow.repositories.QuestionRepository;
import com.samuelvaldes.dojooverflow.repositories.TagRepository;

@Service
public class AppService {

	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------	
	
	private final QuestionRepository qRepository;
	private final AnswerRepository aRepository;
	private final TagRepository tRepository;
	
	public AppService(QuestionRepository qRepository, AnswerRepository aRepository, TagRepository tRepository) {
		this.qRepository = qRepository;
		this.aRepository = aRepository;
		this.tRepository = tRepository;
	}
	
	// ------------------------------------------------
	// II) CRUD methods for Controller class 
	// ------------------------------------------------
	
	// i) CREATE METHODS
	
	// Creates an question
	public Question createQuestion(Question newQuestion) {
		
		// i) Adding Tag to Database
		
		List<Tag> questionTags = new ArrayList<Tag>();
		for (String subject : newQuestion.splitTags()) {
			
			// Check if new incoming tag is in the database
			Tag tagToBeAdded = this.tRepository.findBySubject(subject).orElse(null);
			
			// If the new tag is not in the database, then add this tag to it
			if (tagToBeAdded == null) {
				tagToBeAdded = new Tag(subject);
				this.tRepository.save(tagToBeAdded);
				}
			
			// Add tag to questionTags List, so latter the new question could be constructed with its related tags
			if(!questionTags.contains(tagToBeAdded)) {
				questionTags.add(tagToBeAdded);
			}	
			
		}
		
		// ii) Adding Question to Database
		
		// Setting attribute "tags" (Tag List) from the instance newQuestion as questionTags
		newQuestion.setTags(questionTags);
		
		// Adding new question with related tags to database
		return this.qRepository.save(newQuestion);
		
	}
	
	// Creates an answer
	public Answer createAnswer(Answer newAnswer) {
		return this.aRepository.save(newAnswer);
	}
	
	// ii) READ METHODS
	
	// Retrieves all questions in the DB
	public List<Question> getAllQuestions() {
		return this.qRepository.findAll();
	}
			
	// Retrieves a question by id
	public Question getQuestionById(Long id) {
		return this.qRepository.findById(id).orElse(null);
	}
	
	// Retrieves a question by id
	public Answer getAnswerById(Long id) {
		return this.aRepository.findById(id).orElse(null);
	}
		
	// iv) DELETE METHODS
	
	// Deletes a question by id
	public void deleteQuestionById(Long id) {
		this.qRepository.deleteById(id);
	}
	
	// Deletes a answer by id
	public void deleteAnswerById(Long id) {
		this.aRepository.deleteById(id);
	}
	
}
