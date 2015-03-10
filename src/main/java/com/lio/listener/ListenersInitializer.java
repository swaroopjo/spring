package com.lio.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lio.dao.RsvpDao;

public class ListenersInitializer {

	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("rabbit-listener-context.xml");
	}
	
	
}
