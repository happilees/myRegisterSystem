package com.hsp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Newstype entity. @author MyEclipse Persistence Tools
 */

public class Newstype implements java.io.Serializable {

	// Fields

	private Integer id;
	private Navigationbar navigationbar;
	private String newsTypeName;
	private String templet;
	private Set newses = new HashSet(0);
	private Set worddocs=new HashSet(0);

	// Constructors

	public Set getWorddocs() {
		return worddocs;
	}

	public void setWorddocs(Set worddocs) {
		this.worddocs = worddocs;
	}

	/** default constructor */
	public Newstype() {
	}

	/** minimal constructor */
	public Newstype(Navigationbar navigationbar, String templet) {
		this.navigationbar = navigationbar;
		this.templet = templet;
	}

	/** full constructor */
	public Newstype(Navigationbar navigationbar, String newsTypeName,
			String templet, Set newses,Set worddocs) {
		this.navigationbar = navigationbar;
		this.newsTypeName = newsTypeName;
		this.templet = templet;
		this.newses = newses;
		this.worddocs=worddocs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Navigationbar getNavigationbar() {
		return this.navigationbar;
	}

	public void setNavigationbar(Navigationbar navigationbar) {
		this.navigationbar = navigationbar;
	}

	public String getNewsTypeName() {
		return this.newsTypeName;
	}

	public void setNewsTypeName(String newsTypeName) {
		this.newsTypeName = newsTypeName;
	}

	public String getTemplet() {
		return this.templet;
	}

	public void setTemplet(String templet) {
		this.templet = templet;
	}

	public Set getNewses() {
		return this.newses;
	}

	public void setNewses(Set newses) {
		this.newses = newses;
	}

}