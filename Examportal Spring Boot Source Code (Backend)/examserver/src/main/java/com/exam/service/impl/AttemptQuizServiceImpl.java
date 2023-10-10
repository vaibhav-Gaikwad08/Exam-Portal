package com.exam.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.AttemptQuiz;
import com.exam.repo.AttemptQuizRepository;

@Service
@Transactional
public class AttemptQuizServiceImpl {

    @Autowired
    private AttemptQuizRepository aqr;
     
    
    public AttemptQuiz addAttemptQuiz(AttemptQuiz q) {
    	return aqr.save(q);
    }
    
    public List<AttemptQuiz> getAll(){
    	return aqr.findAll();
    }

    public AttemptQuiz findById(long id){
    	return aqr.findById(id).get();
    }

    public List<AttemptQuiz> getByCategory(String category){
    	return aqr.findByCategory(category);
    }
    

    public List<AttemptQuiz> getByQuizName(String quiz){
    	return aqr.getByQuizName(quiz);
    }
}
