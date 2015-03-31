package com.lio.sc.controllers;
 
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lio.sc.beans.Product;
import com.lio.sc.dao.ProductDAO;
import com.lio.sc.dao.ProductDAOImpl;
 
@Path("/products")
public class ProductService {
 
	private static final Logger logger = LoggerFactory
			.getLogger(ProductService.class);

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Product> getAllProducts() {
		
		ProductDAO dao = new ProductDAOImpl(); 
		List<Product> products = dao.getAllProducts();
		logger.info("Number of Products -->"+ (products != null?products.size():"0"));
		return products;
	}
	@GET
	@Path("/{id}")
	public Product getProduuctById(@PathParam("id") Long id) {
 
		
		Product product = new ProductDAOImpl().getProductById(id);
		logger.info("Number of Products -->"+ (product != null?"1":"0"));
		
		return product;
 
	}
	
	@GET
	@Path("/search/{pName}")
	public List<Product> searchProducts(@PathParam("pName") String productName){
		
		List<Product> products = null;
		products = new ProductDAOImpl().getProductsByName(productName);
		logger.info("Number of Products -->"+ (products != null?products.size():"0"));
		return products;
		
	}
 
}