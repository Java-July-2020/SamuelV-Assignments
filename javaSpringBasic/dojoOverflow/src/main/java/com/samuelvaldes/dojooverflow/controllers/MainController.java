package com.samuelvaldes.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.samuelvaldes.dojooverflow.models.Answer;
import com.samuelvaldes.dojooverflow.models.Question;
import com.samuelvaldes.dojooverflow.services.AppService;


@Controller
public class MainController {

	
	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------
	

	private final AppService appService;

	public MainController(AppService appService) {
		this.appService = appService;
	}
	// ------------------------------------------------
	// II) Path Request Methods
	// ------------------------------------------------
	
	// 1) DASHBOARD REQUESTS
	
	// GET Request to present Index and all Products and Categories in the database
	@GetMapping("/dashboard")
	public String index(Model model) {
		List<Question> questions = appService.getAllQuestions();
		model.addAttribute("questions", questions);
		return "index.jsp";
	}
	
	// 2) QUESTIONS AND ANSWER REQUESTS
	
	// GET Request to present form for adding new question
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "newQuestion.jsp";
	}
	
	// POST Request for adding a new question to the database
	@PostMapping("/questions/new")
	public String createQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newQuestion.jsp";
		}
		else {
			appService.createQuestion(question);
			return "redirect:/dashboard";
		}
	}
	
	// GET Request for showing details of a question and form for introducing an answer
	@GetMapping("/questions/{id}")
	public String showProduct(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model model) {
		
		Question questionSelected = appService.getQuestionById(id);
		
		model.addAttribute("question", questionSelected);
		
		return "showQuestion.jsp";
	}
	
	// POST Request for adding a new question to the database
	@PostMapping("/questions/addAnswer")
	public String createQuestion(@Valid @ModelAttribute("answer") Answer answer, BindingResult result) {
		
		if(result.hasErrors()) {
			return "showQuestion.jsp";
		}
		else {
			Answer newAnswer = appService.createAnswer(answer);
			return "redirect:/questions/"+newAnswer.getQuestion().getId();
		}
	}
	
	// Get Request for deleting a question
	@GetMapping("/questions/delete/{id}")
    public String deleteQuestion(@PathVariable("id") Long id) {
        appService.deleteQuestionById(id);
        return "redirect:/dashboard";
    }
	
	// Get Request for deleting an answer
	@GetMapping("/answers/delete/{id}")
    public String deleteAnswer(@PathVariable("id") Long id) {
        Answer answerSelected = appService.getAnswerById(id);
        String questionId = Long.toString(answerSelected.getQuestion().getId());
		appService.deleteAnswerById(id);
        return "redirect:/questions/"+questionId;
    }
	
	
	

}
