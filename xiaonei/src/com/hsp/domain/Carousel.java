package com.hsp.domain;

/**
 * Carousel entity. @author MyEclipse Persistence Tools
 */

public class Carousel implements java.io.Serializable {

	// Fields

	private Integer id;
	private Newstype newstype;
	private String pictureurl;
	private String teachername;
	private String intro;

	// Constructors

	/** default constructor */
	public Carousel() {
	}

	/** minimal constructor */
	public Carousel(Newstype newstype) {
		this.newstype = newstype;
	}

	/** full constructor */
	public Carousel(Newstype newstype, String pictureurl, String teachername,
			String intro) {
		this.newstype = newstype;
		this.pictureurl = pictureurl;
		this.teachername = teachername;
		this.intro = intro;
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

	public String getPictureurl() {
		return this.pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}

	public String getTeachername() {
		return this.teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}