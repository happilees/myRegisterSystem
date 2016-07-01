package com.hsp.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsp.domain.User;
import com.hsp.service.Inter.UserService;

@Controller//用来标注当前类是springmvc控制类
//@RequestMapping("/user")//如果要加上就相当与struts的namespace
public class LoginAction{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login.do")
	public String login(User user,HttpServletRequest request){
		user=userService.checkUser(user);
		if(user!=null)
		{
			request.setAttribute("message","恭喜你，登录成功！");
			return "success";
		}
		else
		{
			request.setAttribute("message","密码或用户名有误！");
			return "login";
		}
	}
		
}
