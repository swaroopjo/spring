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

import com.lio.sc.beans.Customer;
import com.lio.sc.beans.Product;
import com.lio.sc.util.DerbyDataLoader;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<Customer> getAllCustomers() {
		
		Session session = sessionFactory.openSession();
		
		List<Customer> customers = session.createQuery("from Customer").list();
		
		session.close();
		
		return customers;
	}
	
	public static void main(String[] args){
		CustomerDAOImpl impl = new CustomerDAOImpl(); 
		System.out.println(impl.getAllCustomers());
	}

}
