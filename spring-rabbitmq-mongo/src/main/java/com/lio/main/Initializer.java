package com.lio.main;

import com.lio.listener.ListenersInitializer;
import com.lio.sender.RsvpDataExtractor;

public class Initializer {
	
	private Thread listener = new Thread(
			new Runnable(){

				@Override
				public void run() {
					ListenersInitializer listener = new ListenersInitializer(); 
					
				}}
			);
	
	private Thread sender = new Thread(
			new Runnable(){

				@Override
				public void run() {
					
					RsvpDataExtractor rsvp = new RsvpDataExtractor(); 
					
					
				}
				
			}
			);

	
	public static void main(String[] args){
		
		Initializer init = new Initializer(); 
		init.listener.start();
		init.sender.start();
		
		
	}

}
