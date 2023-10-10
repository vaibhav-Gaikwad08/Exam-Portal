package com.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.exam.model.exam.AttemptQuiz;
import com.exam.model.exam.Category;

@Transactional
public interface AttemptQuizRepository extends JpaRepository<AttemptQuiz, Long> {
	
	@Query(value = "SELECT * FROM attemptquize WHERE quiz_category=?1", nativeQuery = true)
	public List<AttemptQuiz> findByCategory(String category);
	

	@Query(value = "SELECT * FROM attemptquize WHERE quiz_title=?1", nativeQuery = true)
	public List<AttemptQuiz> getByQuizName(String quiz);

}
