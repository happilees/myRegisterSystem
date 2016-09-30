package com.hsp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		testService ts=(testService)ac.getBean("testService");
		System.out.println(ts.getName());

	}

}
