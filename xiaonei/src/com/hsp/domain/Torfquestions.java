package com.hsp.domain;

/**
 * Torfquestions entity. @author MyEclipse Persistence Tools
 */

public class Torfquestions implements java.io.Serializable {

	// Fields

	private Integer id;
	private Exam exam;
	private Integer questionNo;
	private String question;
	private Integer result;

	// Constructors

	/** default constructor */
	public Torfquestions() {
	}

	/** minimal constructor */
	public Torfquestions(Exam exam, Integer questionNo, Integer result) {
		this.exam = exam;
		this.questionNo = questionNo;
		this.result = result;
	}

	/** full constructor */
	public Torfquestions(Exam exam, Integer questionNo, String question,
			Integer result) {
		this.exam = exam;
		this.questionNo = questionNo;
		this.question = question;
		this.result = result;
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

	public Integer getQuestionNo() {
		return this.questionNo;
	}

	public void setQuestionNo(Integer questionNo) {
		this.questionNo = questionNo;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getResult() {
		return this.result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

}