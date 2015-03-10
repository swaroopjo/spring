package com.lio.listener;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lio.dao.RsvpDao;
import com.mongodb.util.JSON;

/**
 * Rsvp Listener listens to the messages on FEED-EXCHANGE that has a Routing pattern rsvp.*
 * 
 *  
 * */
public class RsvpListener implements MessageListener {
	
	public RsvpListener(){
		System.out.println("Rsvp Listener Initialized");
	}
	
	private RsvpDao rsvpDao = (RsvpDao)new ClassPathXmlApplicationContext("mongo-context.xml").getBean("rsvpDao");
	
	
	
		/**
		 * Called when the message is recieved.
		 * */
		public void onMessage(Message message) {
		String messageBody= new String(message.getBody());
		System.out.println("Listener received message----->"+messageBody);
		try{
				System.out.println("Saving to MongoDB");
			rsvpDao.create(messageBody);
		}
		catch(Exception e){
			e.printStackTrace();
		}
			
		}
		
		
		
}

