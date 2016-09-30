package com.hsp.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hsp.domain.Comments;
import com.hsp.domain.Commentsreply;
import com.hsp.domain.User;
import com.hsp.service.Inter.studentServiceInter;

public class replyAction {
	
	HttpServletRequest request=ServletActionContext.getRequest();
	private studentServiceInter studentServiceInter;
	private String liuyanreply;
	public studentServiceInter getStudentServiceInter() {
		return studentServiceInter;
	}
	public void setStudentServiceInter(studentServiceInter studentServiceInter) {
		this.studentServiceInter = studentServiceInter;
	}
	public String getLiuyanreply() {
		return liuyanreply;
	}
	public void setLiuyanreply(String liuyanreply) {
		this.liuyanreply = liuyanreply;
	}
	
	public String liuyanreply(){
		
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null)
		{
			String Commentsid=request.getParameter("Commentsid");
			Commentsreply commentsreply=new Commentsreply();
			Comments comments=(Comments)studentServiceInter.findById(Comments.class,Integer.parseInt(Commentsid));
			comments.setReplyornot(1);
			studentServiceInter.update(comments);
			commentsreply.setComments(comments);
			commentsreply.setReplyTime(new java.util.Date());
			commentsreply.setReply(liuyanreply);
			commentsreply.setAdminId(1);
			studentServiceInter.save(commentsreply);
			List<Comments> list=studentServiceInter.getComments(5,1);
			int pageCount=studentServiceInter.commentcount(5);
			request.setAttribute("pageCount",pageCount);
			request.setAttribute("list", list);

			return "replysuccess";
		}
		else{
			return "nouserlogin";
		}
	}

}
