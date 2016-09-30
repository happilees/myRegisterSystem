package com.hsp.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Commentsreply entity. @author MyEclipse Persistence Tools
 */

public class Commentsreply implements java.io.Serializable {

	// Fields

	private Integer id;
	private Comments comments;
	private Integer adminId;
	private String reply;
	private Date replyTime;

	// Constructors

	/** default constructor */
	public Commentsreply() {
	}

	/** full constructor */
	public Commentsreply(Comments comments, Integer adminId, String reply,
			Date replyTime) {
		this.comments = comments;
		this.adminId = adminId;
		this.reply = reply;
		this.replyTime = replyTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Comments getComments() {
		return this.comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getReply() {
		return this.reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Date getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

}