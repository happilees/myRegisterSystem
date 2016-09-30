package com.hsp.domain;

/**
 * Essay entity. @author MyEclipse Persistence Tools
 */

public class Essay implements java.io.Serializable {

	// Fields

	private Integer id;
	private Exam exam;
	private String answer;
	private String question;
	private Integer essayNo;

	// Constructors

	/** default constructor */
	public Essay() {
	}

	/** full constructor */
	public Essay(Exam exam, String answer, String question, Integer essayNo) {
		this.exam = exam;
		this.answer = answer;
		this.question = question;
		this.essayNo = essayNo;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Exam getExam() {
		return this.exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getEssayNo() {
		return this.essayNo;
	}

	public void setEssayNo(Integer essayNo) {
		this.essayNo = essayNo;
	}

}