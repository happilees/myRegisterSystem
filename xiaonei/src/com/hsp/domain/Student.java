package com.hsp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer id;
	private String studentName;
	private String className;
	private String studentNo;
	private String password;
	private Set commentses = new HashSet(0);
	private Set scores = new HashSet(0);
	private Set answers = new HashSet(0);
	private Set homeworks = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String studentName, String className, String studentNo,
			String password) {
		this.studentName = studentName;
		this.className = className;
		this.studentNo = studentNo;
		this.password = password;
	}

	/** full constructor */
	public Student(String studentName, String className, String studentNo,
			String password, Set commentses, Set scores, Set answers,
			Set homeworks) {
		this.studentName = studentName;
		this.className = className;
		this.studentNo = studentNo;
		this.password = password;
		this.commentses = commentses;
		this.scores = scores;
		this.answers = answers;
		this.homeworks = homeworks;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStudentNo() {
		return this.studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set commentses) {
		this.commentses = commentses;
	}

	public Set getScores() {
		return this.scores;
	}

	public void setScores(Set scores) {
		this.scores = scores;
	}

	public Set getAnswers() {
		return this.answers;
	}

	public void setAnswers(Set answers) {
		this.answers = answers;
	}

	public Set getHomeworks() {
		return this.homeworks;
	}

	public void setHomeworks(Set homeworks) {
		this.homeworks = homeworks;
	}

}