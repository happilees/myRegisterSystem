package com.hsp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Choice entity. @author MyEclipse Persistence Tools
 */

public class Choice implements java.io.Serializable {

	// Fields

	private Integer id;
	private Exam exam;
	private String choiceTitle;
	private Integer choiceNo;
	private String keyA;
	private String keyB;
	private String keyC;
	private String keyD;
	private String keyE;
	private String result;
	private Set answers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Choice() {
	}

	/** minimal constructor */
	public Choice(Exam exam, String choiceTitle, Integer choiceNo, String result) {
		this.exam = exam;
		this.choiceTitle = choiceTitle;
		this.choiceNo = choiceNo;
		this.result = result;
	}

	/** full constructor */
	public Choice(Exam exam, String choiceTitle, Integer choiceNo, String keyA,
			String keyB, String keyC, String keyD, String keyE, String result,
			Set answers) {
		this.exam = exam;
		this.choiceTitle = choiceTitle;
		this.choiceNo = choiceNo;
		this.keyA = keyA;
		this.keyB = keyB;
		this.keyC = keyC;
		this.keyD = keyD;
		this.keyE = keyE;
		this.result = result;
		this.answers = answers;
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

	public String getChoiceTitle() {
		return this.choiceTitle;
	}

	public void setChoiceTitle(String choiceTitle) {
		this.choiceTitle = choiceTitle;
	}

	public Integer getChoiceNo() {
		return this.choiceNo;
	}

	public void setChoiceNo(Integer choiceNo) {
		this.choiceNo = choiceNo;
	}

	public String getKeyA() {
		return this.keyA;
	}

	public void setKeyA(String keyA) {
		this.keyA = keyA;
	}

	public String getKeyB() {
		return this.keyB;
	}

	public void setKeyB(String keyB) {
		this.keyB = keyB;
	}

	public String getKeyC() {
		return this.keyC;
	}

	public void setKeyC(String keyC) {
		this.keyC = keyC;
	}

	public String getKeyD() {
		return this.keyD;
	}

	public void setKeyD(String keyD) {
		this.keyD = keyD;
	}

	public String getKeyE() {
		return this.keyE;
	}

	public void setKeyE(String keyE) {
		this.keyE = keyE;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Set getAnswers() {
		return this.answers;
	}

	public void setAnswers(Set answers) {
		this.answers = answers;
	}

}