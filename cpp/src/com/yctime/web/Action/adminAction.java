package com.yctime.web.Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yctime.pojo.Flag;
import com.yctime.pojo.FlagCustom;
import com.yctime.pojo.Student;
import com.yctime.service.studentService;
import com.yctime.utils.Excel;

public class adminAction extends ActionSupport {
	
	private String username;
	private String password;
	HttpServletRequest request=ServletActionContext.getRequest();
	
	//处理登录请求的
	public String checklogin(){
		
		if(username.equals("shunping")&&password.equals("shunping123"))
		{
			studentService stuService=new studentService();
			int pageCount=stuService.getSstupageCount(20);
			List<Student> studentlist=stuService.getSstudentByPage(20,1);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("studentlist", studentlist);
			request.getSession().setAttribute("user", "shunping");
			return "loginsuccess";
		}
		else
		{
			request.setAttribute("error", "用户名与密码不匹配！");
			return "loginfail";
		}
	}
	
	//查看详细信息的
	public String student(){
		
		Object codekey=request.getSession().getAttribute("user");
		if(codekey!=null)
		{
			studentService stuService=new studentService();
			String studentid=request.getParameter("studentid");
			Student student=new Student();
			student=stuService.getSstudentById(Integer.parseInt(studentid));
			request.setAttribute("student",student);
			return "gostudent";
		}
		else{
			request.setAttribute("error", "");
			return "loginfail";
		}
	}
	//分页
	public String otherStudent(){
		
		Object codekey=request.getSession().getAttribute("user");
		if(codekey!=null)
		{
			String pageNow=request.getParameter("pageNow");	
			studentService stuService=new studentService();
			int s_pageNow=1;
			if(pageNow!=null)
			{
				s_pageNow=Integer.parseInt(pageNow);
			}
			
			int pageCount=stuService.getSstupageCount(20);
			List<Student> studentlist=stuService.getSstudentByPage(20,s_pageNow);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("studentlist", studentlist);
			return "otherStudent";
		}
		else{
			request.setAttribute("error", "");
			return "loginfail";
		}
		
	}
	
	//处理过滤请求
	public String flagFilter(){
		Object codekey=request.getSession().getAttribute("user");
		if(codekey!=null)
		{
			String flagid=request.getParameter("flagid");
			studentService stuService=new studentService();
			Flag flag=stuService.getSflagById(Integer.parseInt(flagid));
			FlagCustom flagCustom=stuService.selectSFlagStudent(Integer.parseInt(flagid));
			List<Student> studentlist=new ArrayList<Student>();
			for(Student student:flagCustom.getStudents())
			{
				studentlist.add(student);
			}
			request.setAttribute("flag",flag);
			request.setAttribute("studentlist",studentlist);
			return "flagFilter";
		}
		else{
			request.setAttribute("error", "");
			return "loginfail";
		}
	}
	
	//前往过滤请求的学生界面
	public String studentFlagfilter(){
		Object codekey=request.getSession().getAttribute("user");
		if(codekey!=null)
		{
			String studentid=request.getParameter("studentid");
			String flagid=request.getParameter("flagid");
			studentService stuService=new studentService();
			Student student=stuService.getSstudentById(Integer.parseInt(studentid));
			Flag flag=stuService.getSflagById(Integer.parseInt(flagid));
			request.setAttribute("student",student);
			request.setAttribute("flag",flag);
			return "studentFlagfilter";
		}
		else{
			request.setAttribute("error", "");
			return "loginfail";
		}
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

}
