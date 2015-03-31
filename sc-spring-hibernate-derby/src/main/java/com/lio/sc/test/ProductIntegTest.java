package com.lio.sc.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;//.SpringJUnit4ClassRunner
import com.lio.sc.beans.Product;
import com.lio.sc.dao.ProductDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-hibernate.xml")
public class ProductIntegTest {

	@Autowired
	private ProductDAO productDAOImpl;
	
	@Test
	public void testgetAllProducts(){
		List<Product> products = productDAOImpl.getAllProducts();
		
		for(Product product:products){
			System.out.println(product);
		}
		
	}

	public ProductDAO getProductDAOImpl() {
		return productDAOImpl;
	}

	public void setProductDAOImpl(ProductDAO productDAOImpl) {
		this.productDAOImpl = productDAOImpl;
	}
	
	
}
