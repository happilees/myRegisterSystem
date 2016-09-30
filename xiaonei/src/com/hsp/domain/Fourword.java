package com.hsp.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Fourword entity. @author MyEclipse Persistence Tools
 */

public class Fourword implements java.io.Serializable {

	// Fields

	private Integer id;
	private News news;
	private String wordcontent;

	// Constructors

	/** default constructor */
	public Fourword() {
	}

	/** full constructor */
	public Fourword(News news, String wordcontent) {
		this.news = news;
		this.wordcontent = wordcontent;
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

	public String getWordcontent() {
		return this.wordcontent;
	}

	public void setWordcontent(String wordcontent) {
		this.wordcontent = wordcontent;
	}

}