package com.hsp.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hsp.service.testService;

public class test {
	
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	private testService testservice;
	
	public String goshowtype(){
		List list=testservice.showtb_type();
		request.setAttribute("list",list);
		//System.out.println("hello");
		return "success";
	}

	public void setTestservice(testService testservice) {
		this.testservice = testservice;
	}

}
