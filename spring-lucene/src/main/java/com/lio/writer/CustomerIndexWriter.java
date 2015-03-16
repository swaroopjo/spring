package com.lio.writer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerIndexWriter {

	private  ApplicationContext ctx = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("spring-context.xml");
	}
	
	public void writeIndexToFile(String inputFilePath) throws IOException{
		
		File customerDF = new File(inputFilePath);
		
		
		
		IndexWriter writer = (IndexWriter)ctx.getBean("indexWriter");
		
		writer.deleteAll();
		writer.commit();
		
		FileInputStream stream = new FileInputStream(customerDF);
			
			BufferedReader bufreader = new BufferedReader(new InputStreamReader(stream));
			int i=0;
			while(bufreader.ready()){
				if(i==0){
					i++;
					continue;
				}
				String[] columns = bufreader.readLine().split("\t");
				  Document doc = new Document();
				   
				  doc.add(new TextField("customerName", columns[1], Field.Store.YES));
				    doc.add(new TextField("contactName", columns[2], Field.Store.YES));
				    doc.add(new TextField("country", columns[5], Field.Store.YES));
				    doc.add(new StringField("customerID", columns[0], Field.Store.YES));
				    writer.addDocument(doc);
				   
			}
			
			writer.commit();
			writer.close();
			
			bufreader.close();
			stream.close();
	
	}
	
	
}
