package com.hsp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Short userTypeId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private Set newses = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Short userTypeId) {
		this.userTypeId = userTypeId;
	}

	/** full constructor */
	public User(Short userTypeId, String userName, String userEmail,
			String userPassword, Set newses) {
		this.userTypeId = userTypeId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.newses = newses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getUserTypeId() {
		return this.userTypeId;
	}

	public void setUserTypeId(Short userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Set getNewses() {
		return this.newses;
	}

	public void setNewses(Set newses) {
		this.newses = newses;
	}

}