package com.hsp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Navigationbar entity. @author MyEclipse Persistence Tools
 */

public class Navigationbar implements java.io.Serializable {

	// Fields

	private Integer id;
	private String navigation;
	private Set newstypes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Navigationbar() {
	}

	/** minimal constructor */
	public Navigationbar(String navigation) {
		this.navigation = navigation;
	}

	/** full constructor */
	public Navigationbar(String navigation, Set newstypes) {
		this.navigation = navigation;
		this.newstypes = newstypes;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNavigation() {
		return this.navigation;
	}

	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}

	public Set getNewstypes() {
		return this.newstypes;
	}

	public void setNewstypes(Set newstypes) {
		this.newstypes = newstypes;
	}

}