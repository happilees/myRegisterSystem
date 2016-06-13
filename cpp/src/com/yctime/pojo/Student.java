package com.yctime.pojo;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
	
	private static final long serialVersionUID=1L;
	private int id;
	private String username;
	private String sex;
	private String classname;
	private String tel;
	private String power;
	private String myflags;
	private String introduce;
	private String isfile;
	private String filename;
	private String qq;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getMyflags() {
		return myflags;
	}
	public void setMyflags(String myflags) {
		this.myflags = myflags;
	}
	public String getIsfile() {
		return isfile;
	}
	public void setIsfile(String isfile) {
		this.isfile = isfile;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
}
