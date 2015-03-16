package com.lio.main;

import java.io.IOException;

import org.apache.lucene.queryparser.classic.ParseException;

import com.lio.reader.CustomerIndexReader;
import com.lio.writer.CustomerIndexWriter;

public class LuceneDemo {

	public static void main(String[] args) throws IOException, ParseException{
		
		CustomerIndexWriter writer = new CustomerIndexWriter(); 
		writer.writeIndexToFile(LuceneDemo.class.getResource("/com/lio/data/Customers.txt").getFile());
		CustomerIndexReader reader = new CustomerIndexReader(); 
		reader.readFromFile("customerName", "Moreno");
		
	}
}
