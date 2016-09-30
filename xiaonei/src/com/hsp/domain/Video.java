package com.hsp.domain;

/**
 * Video entity. @author MyEclipse Persistence Tools
 */

public class Video implements java.io.Serializable {

	// Fields

	private Integer id;
	private News news;
	private String url;
	private String videoname;
	private String videointro;

	// Constructors

	/** default constructor */
	public Video() {
	}

	/** minimal constructor */
	public Video(News news) {
		this.news = news;
	}

	/** full constructor */
	public Video(News news, String url, String videoname, String videointro) {
		this.news = news;
		this.url = url;
		this.videoname = videoname;
		this.videointro = videointro;
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

	public String getVideoname() {
		return this.videoname;
	}

	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}

	public String getVideointro() {
		return this.videointro;
	}

	public void setVideointro(String videointro) {
		this.videointro = videointro;
	}

}