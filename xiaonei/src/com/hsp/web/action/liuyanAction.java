package com.hsp.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hsp.domain.Comments;
import com.hsp.domain.Student;
import com.hsp.domain.User;
import com.hsp.service.Inter.studentServiceInter;

public class liuyanAction {
	
	HttpServletRequest request=ServletActionContext.getRequest();
	private studentServiceInter studentServiceInter;
	
	
	public studentServiceInter getStudentServiceInter() {
		return studentServiceInter;
	}

	public void setStudentServiceInter(studentServiceInter studentServiceInter) {
		this.studentServiceInter = studentServiceInter;
	}

	private String liuyan;

	public String getLiuyan() {
		return liuyan;
	}

	public void setLiuyan(String liuyan) {
		this.liuyan = liuyan;
	}
	//前往留言界面
	public String goliuyan(){
		Student student=(Student)request.getSession().getAttribute("student");
		if(student!=null)
		{
			String s_pageNow=request.getParameter("pageNow");
			int pageNow=1;
			if(s_pageNow!=null)
			{
				pageNow=Integer.parseInt(s_pageNow);
			}
			
			List<Comments> list=studentServiceInter.getComments(5,pageNow);
			int pageCount=studentServiceInter.commentcount(5);
			request.setAttribute("pageCount",pageCount);
			request.setAttribute("list", list);
			return "goliuyan";
		}
		else{
			String flag=request.getParameter("flag");
			request.setAttribute("flag",flag);
			return "nologin";
		}	
	}
	//将留言写进数据库
	public String liuyan(){
		
		Student student=(Student)request.getSession().getAttribute("student");
		if(student!=null)
		{
			Comments comments=new Comments();
			comments.setStudent(student);
			comments.setComments(liuyan);
			comments.setReplyornot(0);
			comments.setCommentsTime(new java.util.Date());
			studentServiceInter.save(comments);
			String s_pageNow=request.getParameter("pageNow");
			//System.out.println("s_pageNow="+s_pageNow);
			int pageNow=1;
			if(s_pageNow!=null)
			{
				pageNow=Integer.parseInt(s_pageNow);
			}
			List<Comments> list=studentServiceInter.getComments(5,pageNow);
			int pageCount=studentServiceInter.commentcount(5);
			request.setAttribute("pageCount",pageCount);
			request.setAttribute("list", list);
			
			return "liuyansuccess";
		}
		else{
			String flag=request.getParameter("flag");
			request.setAttribute("flag",flag);
			return "nologin";
		}
	}
	//后台管理前往留言界面
	public String gomanagerliuyan(){
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null)
		{
			String s_pageNow=request.getParameter("pageNow");
			int pageNow=1;
			if(s_pageNow!=null)
			{
				pageNow=Integer.parseInt(s_pageNow);
			}
			List<Comments> list=studentServiceInter.getComments(5,pageNow);
			int pageCount=studentServiceInter.commentcount(5);
			request.setAttribute("pageCount",pageCount);
			request.setAttribute("list", list);
			return "gomanagerliuyan";
		}
		else{
			return "nouserlogin";
		}
	}
	
	//前往回复界面
	public String goreply(){
	
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null)
		{
			String Commentsid=request.getParameter("Commentsid");
			Comments comments=(Comments)studentServiceInter.findById(Comments.class,Integer.parseInt(Commentsid));
		    request.setAttribute("comments",comments);
			return "goreply";
		}
		else{
			return "nouserlogin";
		}
		}

}