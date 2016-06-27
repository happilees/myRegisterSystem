package com.hsp.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hsp.domain.User;
import com.hsp.service.Inter.UserService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport {
	
	@Autowired
	private UserService userService;
	
	HttpServletRequest request=ServletActionContext.getRequest();
	
	private String username;
	private String password;
	
	//Action方法
	public String login(){
		User user=new User();
		user.setUsername(username);
        user.setPassword(password);
        System.out.println("username="+username+" password="+password);
        user=userService.checkUser(user);
        if(user!=null)
        {
        	request.setAttribute("message","恭喜你，登录成功！");
        	return "loginSuccess";
        }
        else{
        	request.setAttribute("message","密码或用户名有误！");
        	return "loginFail";
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
