package com.hsp.domain;

/**
 * Pptorphoto entity. @author MyEclipse Persistence Tools
 */

public class Pptorphoto implements java.io.Serializable {

	// Fields

	private Integer id;
	private News news;
	private String url;
	private String photoname;
	private String photointro;

	// Constructors

	/** default constructor */
	public Pptorphoto() {
	}

	/** minimal constructor */
	public Pptorphoto(News news) {
		this.news = news;
	}

	/** full constructor */
	public Pptorphoto(News news, String url, String photoname, String photointro) {
		this.news = news;
		this.url = url;
		this.photoname = photoname;
		this.photointro = photointro;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPhotoname() {
		return this.photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

	public String getPhotointro() {
		return this.photointro;
	}

	public void setPhotointro(String photointro) {
		this.photointro = photointro;
	}

}