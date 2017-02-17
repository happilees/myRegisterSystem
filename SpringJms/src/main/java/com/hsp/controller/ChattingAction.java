package com.hsp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hsp.jms.Listener;
import com.hsp.jms.Publisher;

@Controller
public class ChattingAction{

	@RequestMapping(value = "/publish", method = RequestMethod.POST)
	public String jmsMessagePublish(HttpServletRequest request) {

		//从sring容器中取出publisher，执行发布的动作
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		Publisher publisher = (Publisher) context.getBean("publisher");
        String said = request.getParameter("said");
		publisher.sendTalk(said);
		//关闭ApplicationContext
		((ClassPathXmlApplicationContext)context).close();
		return "redirect:/";
	}
	
}