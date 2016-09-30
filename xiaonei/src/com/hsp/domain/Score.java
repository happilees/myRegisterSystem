package com.hsp.domain;

import java.sql.Timestamp;

/**
 * Score entity. @author MyEclipse Persistence Tools
 */

public class Score implements java.io.Serializable {

	// Fields

	private Integer id;
	private Exam exam;
	private Student student;
	private Integer score;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public Score() {
	}

	/** minimal constructor */
	public Score(Exam exam, Student student, Timestamp addTime) {
		this.exam = exam;
		this.student = student;
		this.addTime = addTime;
	}

	/** full constructor */
	public Score(Exam exam, Student student, Integer score, Timestamp addTime) {
		this.exam = exam;
		this.student = student;
		this.score = score;
		this.addTime = addTime;
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

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}