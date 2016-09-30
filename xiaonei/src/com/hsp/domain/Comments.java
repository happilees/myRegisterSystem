package com.hsp.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Comments entity. @author MyEclipse Persistence Tools
 */

public class Comments implements java.io.Serializable {

	// Fields

	private Integer id;
	private Student student;
	private String comments;
	private Date commentsTime;
	private Integer replyornot;
	private Set commentsreplies = new HashSet(0);

	// Constructors

	/** default constructor */
	public Comments() {
	}

	/** minimal constructor */
	public Comments(Student student, String comments, Date commentsTime,
			Integer replyornot) {
		this.student = student;
		this.comments = comments;
		this.commentsTime = commentsTime;
		this.replyornot = replyornot;
	}

	/** full constructor */
	public Comments(Student student, String comments, Date commentsTime,
			Integer replyornot, Set commentsreplies) {
		this.student = student;
		this.comments = comments;
		this.commentsTime = commentsTime;
		this.replyornot = replyornot;
		this.commentsreplies = commentsreplies;
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

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getCommentsTime() {
		return this.commentsTime;
	}

	public void setCommentsTime(Date commentsTime) {
		this.commentsTime = commentsTime;
	}

	public Integer getReplyornot() {
		return this.replyornot;
	}

	public void setReplyornot(Integer replyornot) {
		this.replyornot = replyornot;
	}

	public Set getCommentsreplies() {
		return this.commentsreplies;
	}

	public void setCommentsreplies(Set commentsreplies) {
		this.commentsreplies = commentsreplies;
	}

}