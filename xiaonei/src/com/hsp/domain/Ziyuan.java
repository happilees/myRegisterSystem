package com.hsp.domain;

/**
 * Ziyuan entity. @author MyEclipse Persistence Tools
 */

public class Ziyuan implements java.io.Serializable {

	// Fields

	private Integer id;
	private Newstype newstype;
	private String intro;
	private String ziyuanurl;

	// Constructors

	/** default constructor */
	public Ziyuan() {
	}

	/** minimal constructor */
	public Ziyuan(Newstype newstype) {
		this.newstype = newstype;
	}

	/** full constructor */
	public Ziyuan(Newstype newstype, String intro, String ziyuanurl) {
		this.newstype = newstype;
		this.intro = intro;
		this.ziyuanurl = ziyuanurl;
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

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getZiyuanurl() {
		return this.ziyuanurl;
	}

	public void setZiyuanurl(String ziyuanurl) {
		this.ziyuanurl = ziyuanurl;
	}

}