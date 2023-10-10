package com.exam.model.exam;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.exam.model.User;

@Entity
@Table(name = "attemptquize")
public class AttemptQuiz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String quiz_title;
	private String maxMarks;
	private String obtainedMark;
	private String quiz_category;
	private String candidate_name;
	private String attempted_date;
	public AttemptQuiz() {
		super();
	}
	public AttemptQuiz(long id, String quiz_title, String maxMarks, String obtainedMark, String quiz_category,
			String candidate_name, String attempted_date) {
		super();
		this.id = id;
		this.quiz_title = quiz_title;
		this.maxMarks = maxMarks;
		this.obtainedMark = obtainedMark;
		this.quiz_category = quiz_category;
		this.candidate_name = candidate_name;
		this.attempted_date = attempted_date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQuiz_title() {
		return quiz_title;
	}
	public void setQuiz_title(String quiz_title) {
		this.quiz_title = quiz_title;
	}
	public String getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}
	public String getObtainedMark() {
		return obtainedMark;
	}
	public void setObtainedMark(String obtainedMark) {
		this.obtainedMark = obtainedMark;
	}
	public String getQuiz_category() {
		return quiz_category;
	}
	public void setQuiz_category(String quiz_category) {
		this.quiz_category = quiz_category;
	}
	public String getCandidate_name() {
		return candidate_name;
	}
	public void setCandidate_name(String candidate_name) {
		this.candidate_name = candidate_name;
	}
	public String getAttempted_date() {
		return attempted_date;
	}
	public void setAttempted_date(String attempted_date) {
		this.attempted_date = attempted_date;
	}
	
}
