package com.hsp.domain;

/**
 * Answer entity. @author MyEclipse Persistence Tools
 */

public class Answer implements java.io.Serializable {

	// Fields

	private Integer id;
	private Exam exam;
	private Choice choice;
	private Student student;
	private String studentResult;
	private String typeName;
	private Integer flag;

	// Constructors

	/** default constructor */
	public Answer() {
	}

	/** minimal constructor */
	public Answer(Exam exam, Choice choice, Student student, String typeName,
			Integer flag) {
		this.exam = exam;
		this.choice = choice;
		this.student = student;
		this.typeName = typeName;
		this.flag = flag;
	}

	/** full constructor */
	public Answer(Exam exam, Choice choice, Student student,
			String studentResult, String typeName, Integer flag) {
		this.exam = exam;
		this.choice = choice;
		this.student = student;
		this.studentResult = studentResult;
		this.typeName = typeName;
		this.flag = flag;
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

	public Choice getChoice() {
		return this.choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getStudentResult() {
		return this.studentResult;
	}

	public void setStudentResult(String studentResult) {
		this.studentResult = studentResult;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}