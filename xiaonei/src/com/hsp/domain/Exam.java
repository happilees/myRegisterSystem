package com.hsp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Exam entity. @author MyEclipse Persistence Tools
 */

public class Exam implements java.io.Serializable {

	// Fields

	private Integer id;
	private String examName;
	private Integer isStart;
	private Integer score;
	private Integer time;
	private Set choices = new HashSet(0);
	private Set fillblanks = new HashSet(0);
	private Set answers = new HashSet(0);
	private Set scores = new HashSet(0);
	private Set essaies = new HashSet(0);
	private Set torfquestionses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Exam() {
	}

	/** minimal constructor */
	public Exam(String examName, Integer isStart, Integer time) {
		this.examName = examName;
		this.isStart = isStart;
		this.time = time;
	}

	/** full constructor */
	public Exam(String examName, Integer isStart, Integer score, Integer time,
			Set choices, Set fillblanks, Set answers, Set scores, Set essaies,
			Set torfquestionses) {
		this.examName = examName;
		this.isStart = isStart;
		this.score = score;
		this.time = time;
		this.choices = choices;
		this.fillblanks = fillblanks;
		this.answers = answers;
		this.scores = scores;
		this.essaies = essaies;
		this.torfquestionses = torfquestionses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExamName() {
		return this.examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Integer getIsStart() {
		return this.isStart;
	}

	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Set getChoices() {
		return this.choices;
	}

	public void setChoices(Set choices) {
		this.choices = choices;
	}

	public Set getFillblanks() {
		return this.fillblanks;
	}

	public void setFillblanks(Set fillblanks) {
		this.fillblanks = fillblanks;
	}

	public Set getAnswers() {
		return this.answers;
	}

	public void setAnswers(Set answers) {
		this.answers = answers;
	}

	public Set getScores() {
		return this.scores;
	}

	public void setScores(Set scores) {
		this.scores = scores;
	}

	public Set getEssaies() {
		return this.essaies;
	}

	public void setEssaies(Set essaies) {
		this.essaies = essaies;
	}

	public Set getTorfquestionses() {
		return this.torfquestionses;
	}

	public void setTorfquestionses(Set torfquestionses) {
		this.torfquestionses = torfquestionses;
	}

}