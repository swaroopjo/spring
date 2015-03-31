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

import com.lio.sc.beans.Order;
import com.lio.sc.util.DerbyDataLoader;

@Repository
public class OrderDAOImpl implements OrderDAO{

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<Order> getAllOrders() {
		
		Session session = sessionFactory.openSession();
		
		List<Order> Orders = session.createQuery("from Order").list();
		
		session.close();
		
		return Orders;
	}

	
//	public static void main(String[] args){
//		OrderDAOImpl impl = new OrderDAOImpl(); 
//		System.out.println(impl.getAllOrders());
//	}

}
