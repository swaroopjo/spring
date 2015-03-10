package com.lio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.mongodb.MongoClient;


public class RsvpDao {

	private static final String RSVP_COLLECTION = "rsvp";
	
	private MongoOperations mongoOps;
	
	public void create( String messageBody){
		mongoOps.save(messageBody, RSVP_COLLECTION);
	}

	public MongoOperations getMongoOps() {
		return mongoOps;
	}

	public void setMongoOps(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	} 
	
}
