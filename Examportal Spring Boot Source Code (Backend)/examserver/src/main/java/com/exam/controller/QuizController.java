package com.exam.controller;

import com.exam.model.exam.AttemptQuiz;
import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.service.QuizService;
import com.exam.service.impl.AttemptQuizServiceImpl;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private QuizService quizService;
	@Autowired
	private AttemptQuizServiceImpl aqs;

	// add quiz service
	@PostMapping("/")
	public ResponseEntity<Quiz> add(@RequestBody Quiz quiz) {
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}

	// update quiz

	@PutMapping("/")
	public ResponseEntity<Quiz> update(@RequestBody Quiz quiz) {
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}

	// get quiz
	@GetMapping("/")
	public ResponseEntity<?> quizzes() {
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}

	// get single quiz
	@GetMapping("/{qid}")
	public Quiz quiz(@PathVariable("qid") Long qid) {
		return this.quizService.getQuiz(qid);
	}

	// delete the quiz
	@DeleteMapping("/{qid}")
	public void delete(@PathVariable("qid") Long qid) {
		this.quizService.deleteQuiz(qid);
	}

	@GetMapping("/category/{cid}")
	public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid) {
		Category category = new Category();
		category.setCid(cid);
		return this.quizService.getQuizzesOfCategory(category);
	}

	// get active quizzes
	@GetMapping("/active")
	public List<Quiz> getActiveQuizzes() {
		return this.quizService.getActiveQuizzes();
	}

	// get active quizzes of category
	@GetMapping("/category/active/{cid}")
	public List<Quiz> getActiveQuizzes(@PathVariable("cid") Long cid) {
		Category category = new Category();
		category.setCid(cid);
		return this.quizService.getActiveQuizzesOfCategory(category);
	}

	@PostMapping("/addAttempts")
	public ResponseEntity<AttemptQuiz> addAttemptQuiz(@RequestBody AttemptQuiz quiz) {
		return ResponseEntity.ok(this.aqs.addAttemptQuiz(quiz));
	}

	@GetMapping("/getAttempts")
	public List<AttemptQuiz> getAllQuiz() {
		return this.aqs.getAll();
	}

	@GetMapping("/getAttemptsByCategory/{category}")
	public List<AttemptQuiz> getAllQuiz(@PathVariable("category") String category) {
		if(category.equals("all"))
			return this.aqs.getAll();
		return this.aqs.getByCategory(category);
	}


	@GetMapping("/getAttemptQuizByQuizeName/{quiz}")
	public List<AttemptQuiz> getAllQuizByQuizName(@PathVariable("quiz") String quiz) {
		if(quiz.equals("all"))
			return this.aqs.getAll();
		return this.aqs.getByQuizName(quiz);
	}

}
