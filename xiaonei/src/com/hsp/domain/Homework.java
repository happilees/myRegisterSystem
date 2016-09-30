package com.hsp.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Homework entity. @author MyEclipse Persistence Tools
 */

public class Homework implements java.io.Serializable {

	// Fields

	private Integer id;
	private Student student;
	private String fileUrl;
	private String homeName;
	private Date submitTime;
	private Integer downloadTime;

	// Constructors

	/** default constructor */
	public Homework() {
	}

	/** minimal constructor */
	public Homework(Student student, String fileUrl, Date submitTime,
			Integer downloadTime) {
		this.student = student;
		this.fileUrl = fileUrl;
		this.submitTime = submitTime;
		this.downloadTime = downloadTime;
	}

	/** full constructor */
	public Homework(Student student, String fileUrl, String homeName,
			Date submitTime, Integer downloadTime) {
		this.student = student;
		this.fileUrl = fileUrl;
		this.homeName = homeName;
		this.submitTime = submitTime;
		this.downloadTime = downloadTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getFileUrl() {
		return this.fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getHomeName() {
		return this.homeName;
	}

	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}

	public Date getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public Integer getDownloadTime() {
		return this.downloadTime;
	}

	public void setDownloadTime(Integer downloadTime) {
		this.downloadTime = downloadTime;
	}

}