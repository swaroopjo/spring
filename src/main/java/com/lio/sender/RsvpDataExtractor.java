package com.lio.sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.parser.JSONParser;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.AbstractConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RsvpDataExtractor {

	public RsvpDataExtractor(){
		
		this.feedData();
	}
	static String STREAMING_API_URL="http://stream.meetup.com/2/rsvps";
	static ApplicationContext context = new ClassPathXmlApplicationContext("rabbit-sender-context.xml");
	ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(500);
	
	Thread dataExtractor = new Thread(
			new Runnable(){

		@Override
		public void run() {
			
			DefaultHttpClient client = new DefaultHttpClient();
	        HttpGet get = new HttpGet(STREAMING_API_URL);
	        HttpResponse response;
	        try {
	            //Execute
	            response = client.execute(get);
	            StatusLine status = response.getStatusLine();
	            if(status.getStatusCode() == 200){
	                InputStream inputStream = response.getEntity().getContent();
	                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	                String in;
	                //Read line by line
	                while((in = reader.readLine())!=null){
	                    try{
	                       
	                    	Object json = new JSONParser().parse(in);
	                        queue.add(json);
	                        Thread.sleep(1000);
	                    }catch (Exception e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        } catch (IOException e) {
	           e.printStackTrace();
	           
	            try {
	                Thread.sleep(10000);
	            } catch (InterruptedException e1) {
	            }
	        }
			
		}}
			);
	
	public void feedData(){
		AbstractConnectionFactory connectionFactory = (AbstractConnectionFactory) context.getBean("connectionFactory");// getting a reference to the sender bean

		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setExchange("FEED-EXCHANGE");
		
		this.dataExtractor.start();
		
		while(true){
			
			Object obj = queue.poll();
			if(obj != null){
				rabbitTemplate.convertAndSend("rsvp.key", obj.toString());
				System.out.println("Sending Feed Data to MQ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	
}
