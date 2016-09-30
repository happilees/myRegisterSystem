package com.hsp.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Word entity. @author MyEclipse Persistence Tools
 */

public class Word implements java.io.Serializable {

	// Fields

	private Integer id;
	private Newstype newstype;
	private String wordcontent;
	private Date addtime;

	// Constructors

	/** default constructor */
	public Word() {
	}

	/** full constructor */
	public Word(Newstype newstype, String wordcontent, Date addtime) {
		this.newstype = newstype;
		this.wordcontent = wordcontent;
		this.addtime = addtime;
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

	public String getWordcontent() {
		return this.wordcontent;
	}

	public void setWordcontent(String wordcontent) {
		this.wordcontent = wordcontent;
	}

	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

}