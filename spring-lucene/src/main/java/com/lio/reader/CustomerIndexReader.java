package com.lio.reader;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerIndexReader {

	private  ApplicationContext ctx = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("spring-context.xml");
	}
	
	public void readFromFile(String colName, String searchTerm) throws  ParseException, IOException{
		Query query = new QueryParser(Version.LUCENE_40,colName, (StandardAnalyzer)ctx.getBean("luceneAnalyzer")).parse(searchTerm);
		
		int hitsPerPage = 10;
	    IndexReader reader = DirectoryReader.open((SimpleFSDirectory)ctx.getBean("indexDirectory"));
	    IndexSearcher searcher = new IndexSearcher(reader);
	    TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
	    searcher.search(query, collector);
	    ScoreDoc[] hits = collector.topDocs().scoreDocs;
	    
	    System.out.println("Found " + hits.length + " hits.");
	    for(int j=0;j<hits.length;++j) {
	      int docId = hits[j].doc;
	      Document d = searcher.doc(docId);
	      System.out.println((j + 1) + ". " + d.get("customerName") + "\t" + d.get("contactName")+ "\t" + d.get("country")+ "\t" + d.get("customerID"));
	    }
	    reader.close();
		
	}
}
