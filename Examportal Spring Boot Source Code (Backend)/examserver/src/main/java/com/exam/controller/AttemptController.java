package com.exam.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.AttemptQuizRequest;
import com.exam.model.User;
import com.exam.model.exam.AttemptQuiz;
import com.exam.service.impl.AttemptQuizServiceImpl;

@RestController
@RequestMapping("/addAttempts/")
public class AttemptController {
	private AttemptQuizServiceImpl attemptQuizService;
	
	public AttemptController(AttemptQuizServiceImpl attemptQuizService) {
		this.attemptQuizService = attemptQuizService;
	}

	@PostMapping("/")
	public AttemptQuiz attemptQuiz(@RequestBody AttemptQuizRequest q, Authentication authentication) {
		User user=(User) authentication.getPrincipal();
		System.out.println(user.getFirstName());
		AttemptQuiz aq = new AttemptQuiz();
		aq.setMaxMarks(q.getMaxMarks());
		aq.setObtainedMark(q.getObtainedMark());
		aq.setMaxMarks(q.getMaxMarks());
		
		
		return attemptQuizService.addAttemptQuiz(aq);
	}
	
//	public List<AttemptQuiz> getAllAttempts(){
//		
//	}
}
