package com.lio.sc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lio.sc.beans.Product;
import com.lio.sc.util.DerbyDataLoader;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<Product> getAllProducts() {
		
		Session session = sessionFactory.openSession();
		
		List<Product> products = session.createQuery("from Product").list();
		
		session.close();
		
		return products;
	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		ProductDAOImpl impl = new ProductDAOImpl(); 
		System.out.println(impl.getAllProducts());
	}

}
