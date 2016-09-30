package com.hsp.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hsp.domain.Comments;
import com.hsp.domain.Student;
import com.hsp.domain.Teacherphw;
import com.hsp.domain.User;
import com.hsp.service.Inter.studentServiceInter;
import com.hsp.service.Inter.thirdbarServiceInter;
import com.hsp.service.Inter.wordServiceInter;

public class loginAction {
	
	HttpServletRequest request=ServletActionContext.getRequest();
	private studentServiceInter studentServiceInter;
	private thirdbarServiceInter thirdbarServiceInter;
	private wordServiceInter wordServiceInter;
	private String username;//指的是学号
	private String password;
 
	
	public wordServiceInter getWordServiceInter() {
		return wordServiceInter;
	}
	public void setWordServiceInter(wordServiceInter wordServiceInter) {
		this.wordServiceInter = wordServiceInter;
	}
	public thirdbarServiceInter getThirdbarServiceInter() {
		return thirdbarServiceInter;
	}
	public void setThirdbarServiceInter(thirdbarServiceInter thirdbarServiceInter) {
		this.thirdbarServiceInter = thirdbarServiceInter;
	}
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
	//前往登录
	public String gologin(){
		String flag=request.getParameter("flag");
		request.setAttribute("flag",flag);
		return "gologin";
	}
	//前往注册
		public String goregister(){
			String flag=request.getParameter("flag");
			request.setAttribute("flag",flag);
			return "goregister";
		}
	//注销登录
	public String killlogin(){
		Student student=(Student)request.getSession().getAttribute("student");
		if(student!=null)
		{
			request.getSession().invalidate();
			List kecheng=thirdbarServiceInter.getthirdbardesc(31, 8, 1);
			List carousel=wordServiceInter.getcarousel();
			request.setAttribute("carousel",carousel);
			request.setAttribute("kecheng",kecheng);
			return "loginsuccess";
		}
		else{
		return "nologin";
		}
	}
	//处理登录
	public String checklogin(){
		
		Student student=new Student();
		student.setStudentNo(username);
		student.setPassword(password);
		student=studentServiceInter.checkstudent(student);
		if(student!=null)
		{
			List kecheng=thirdbarServiceInter.getthirdbardesc(31, 8, 1);
			List carousel=wordServiceInter.getcarousel();
			request.setAttribute("carousel",carousel);
			request.setAttribute("kecheng",kecheng);
			request.getSession().setAttribute("student", student);
			request.setAttribute("student",student);
			String flag=request.getParameter("flag");
			if(flag.equals("1"))
			{
				List<Comments> list=studentServiceInter.getComments(5,1);
				int pageCount=studentServiceInter.commentcount(5);
				request.setAttribute("pageCount",pageCount);
				request.setAttribute("list", list);
				return "goliuyan";
			}
			if(flag.equals("2"))
			{
				return "login";
			}
			if(flag.equals("3"))
			{
				List hwlist=studentServiceInter.getteacherhw(10,1);
				request.setAttribute("hwlist",hwlist);
				return "gohomework";
			}
			else
			{
				return "loginsuccess";
			}
		}
		else{
			request.setAttribute("message", "学号或密码有误!");
			return "loginfail";
		}
	}
    //后台登录
	public String checkuserlogin(){
		User user=new User();
		user.setUserName(username);
		user.setUserPassword(password);
		user=studentServiceInter.checkuser(user);
		if(user!=null)
		{
			request.getSession().setAttribute("user", user);
			return "userloginsuccess";
		}
		else{
			request.setAttribute("message", "用户名或密码有误!");
			return "userloginfail";
		}
	}
	
	public String outlogin(){
		request.getSession().invalidate();
		return "out";
	}
	
	//后台进入首页
	public String goshouye(){
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null)
		{
			return "userloginsuccess";
		}
		else{
			return "userloginfail";
		}
	}
}