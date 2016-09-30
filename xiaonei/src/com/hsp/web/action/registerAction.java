package com.hsp.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hsp.domain.Student;
import com.hsp.service.Inter.studentServiceInter;

public class registerAction {
	
	HttpServletRequest request=ServletActionContext.getRequest();
	private studentServiceInter studentServiceInter;
	private String studentNo;
	private String classname;
	private String username;
	private String password;
	
	
	public studentServiceInter getStudentServiceInter() {
		return studentServiceInter;
	}
	public void setStudentServiceInter(studentServiceInter studentServiceInter) {
		this.studentServiceInter = studentServiceInter;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	
	
	//处理注册
	public String register(){
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(studentNo);
		System.out.println(classname);
		Student student=new Student();
		student.setPassword(password);
		student.setStudentName(username);
		student.setStudentNo(studentNo);
		student.setClassName(classname);
		Student student2=(Student)studentServiceInter.checkstudent(student);
		if(student2!=null)
		{
			request.setAttribute("message", "用户已注册，如需再次注册，请使用不同密码");
			return "registersuccess";
		}
		else
		{
			studentServiceInter.save(student);
			request.setAttribute("message", "注册成功");
			return "registersuccess";
		}
	}

}