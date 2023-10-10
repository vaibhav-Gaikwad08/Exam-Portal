package com.exam.model;

public class AttemptQuizRequest {
	private long id;
	private String quiz_title;
	private String maxMarks;
	private String obtainedMark;
	
	public AttemptQuizRequest(long id, String quiz_title, String maxMarks, String obtainedMark) {
		this.quiz_title = quiz_title;
		this.maxMarks = maxMarks;
		this.obtainedMark = obtainedMark;
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
	
	
}
