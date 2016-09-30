package com.hsp.domain;

/**
 * Teacherphw entity. @author MyEclipse Persistence Tools
 */

public class Teacherphw implements java.io.Serializable {

	// Fields

	private Integer id;
	private String ewquire;
	private String hwname;

	// Constructors

	/** default constructor */
	public Teacherphw() {
	}

	/** minimal constructor */
	public Teacherphw(String hwname) {
		this.hwname = hwname;
	}

	/** full constructor */
	public Teacherphw(String ewquire, String hwname) {
		this.ewquire = ewquire;
		this.hwname = hwname;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEwquire() {
		return this.ewquire;
	}

	public void setEwquire(String ewquire) {
		this.ewquire = ewquire;
	}

	public String getHwname() {
		return this.hwname;
	}

	public void setHwname(String hwname) {
		this.hwname = hwname;
	}

}