package com.hsp.domain;

import java.util.Date;

/**
 * Worddoc entity. @author MyEclipse Persistence Tools
 */

public class Worddoc implements java.io.Serializable {

	// Fields

	private Integer id;
	private Newstype newstype;
	private String wordname;
	private String wordurl;
	private Date addtime;

	// Constructors

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	/** default constructor */
	public Worddoc() {
	}

	/** full constructor */
	public Worddoc(Newstype newstype, String wordname, String wordurl,Date addtime) {
		this.newstype = newstype;
		this.wordname = wordname;
		this.wordurl = wordurl;
		this.addtime=addtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Newstype getNewstype() {
		return this.newstype;
	}

	public void setNewstype(Newstype newstype) {
		this.newstype = newstype;
	}

	public String getWordname() {
		return this.wordname;
	}

	public void setWordname(String wordname) {
		this.wordname = wordname;
	}

	public String getWordurl() {
		return this.wordurl;
	}

	public void setWordurl(String wordurl) {
		this.wordurl = wordurl;
	}

}