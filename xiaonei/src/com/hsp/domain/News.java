package com.hsp.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Integer id;
	private Newstype newstype;
	private String newsTitle;
	private Integer flag;
	private Date addtime;
	private Set pptorphotos = new HashSet(0);
	private Set videos = new HashSet(0);

	// Constructors

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(Newstype newstype, String newsTitle, Date addtime,Integer flag) {
		this.newstype = newstype;
		this.newsTitle = newsTitle;
		this.addtime = addtime;
		this.flag=flag;
	}

	/** full constructor */
	public News(Newstype newstype, String newsTitle, Date addtime,Integer flag,
			Set pptorphotos, Set videos) {
		this.newstype = newstype;
		this.newsTitle = newsTitle;
		this.addtime = addtime;
		this.flag=flag;
		this.pptorphotos = pptorphotos;
		this.videos = videos;
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

	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Set getPptorphotos() {
		return this.pptorphotos;
	}

	public void setPptorphotos(Set pptorphotos) {
		this.pptorphotos = pptorphotos;
	}

	public Set getVideos() {
		return this.videos;
	}

	public void setVideos(Set videos) {
		this.videos = videos;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	

}