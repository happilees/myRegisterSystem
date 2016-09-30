package com.hsp.domain;

/**
 * Showpicture entity. @author MyEclipse Persistence Tools
 */

public class Showpicture implements java.io.Serializable {

	// Fields

	private Integer id;
	private String url;

	// Constructors

	/** default constructor */
	public Showpicture() {
	}

	/** full constructor */
	public Showpicture(String url) {
		this.url = url;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}