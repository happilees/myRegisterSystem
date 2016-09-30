package com.hsp.domain;

/**
 * Fourworddoc entity. @author MyEclipse Persistence Tools
 */

public class Fourworddoc implements java.io.Serializable {

	// Fields

	private Integer id;
	private News news;
	private String wordname;
	private String wordurl;

	// Constructors

	/** default constructor */
	public Fourworddoc() {
	}

	/** full constructor */
	public Fourworddoc(News news, String wordname, String wordurl) {
		this.news = news;
		this.wordname = wordname;
		this.wordurl = wordurl;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public News getNews() {
		return this.news;
	}

	public void setNews(News news) {
		this.news = news;
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