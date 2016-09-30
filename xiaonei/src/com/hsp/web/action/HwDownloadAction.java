package com.hsp.web.action;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hsp.domain.User;
import com.hsp.util.CompressZip;
import com.opensymphony.xwork2.ActionSupport;

public class HwDownloadAction extends ActionSupport{
	
	    HttpServletRequest request=ServletActionContext.getRequest();
	    private String fileName;  
	      
	    public String getFileName() {  
	        return fileName; 
	    }  
	  
	    public void setFileName(String fileName) {  
	        this.fileName = fileName;  
	    }  
	  
	  //返回一个输入流，作为一个客户端来说是一个输入流，但对于服务器端是一个 输出流  
	    public InputStream getDownloadFile() throws Exception  
	    {  
	    	   String classRoom=request.getParameter("classRoom");
	    	   //System.out.println("classRoom="+classRoom);
	           this.fileName = classRoom+".zip" ;  
	           //获取资源路径  
	           return ServletActionContext.getServletContext().getResourceAsStream("/uploadstuword"+"/"+classRoom+".zip") ;  
	    }  
	      
	    @Override  
	    public String execute() throws Exception {
	    	User user=(User)request.getSession().getAttribute("user");
			if(user!=null)
			{
				String classRoom=request.getParameter("classRoom");
				CompressZip zc = new  CompressZip(ServletActionContext.getServletContext().getRealPath("/uploadstuword")+"/"+classRoom+".zip");  
		        zc.compressExe(ServletActionContext.getServletContext().getRealPath("/uploadstuword")+"/"+classRoom);  
	            return SUCCESS;  
	        }  
			else{
				return "userloginfail";
			}
	    }
	}  