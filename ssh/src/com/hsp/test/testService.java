package com.hsp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hsp.domain.User;
import com.hsp.service.Inter.UserService;

public class testService {
	
	private ApplicationContext ctx=null;
	private UserService userService=null;
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		userService=(UserService)ctx.getBean("userService");
	}
	
	@Test
	public void testCheckUserService()
	{
		User user=new User();
		user.setUsername("wayne");
		user.setPassword("123");
		user=userService.checkUser(user);
		System.out.println("username="+user.getUsername()+" id="+user.getId());
	}

}
