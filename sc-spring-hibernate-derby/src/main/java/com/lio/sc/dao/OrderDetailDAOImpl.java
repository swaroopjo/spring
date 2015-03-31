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

import com.lio.sc.beans.OrderDetail;
import com.lio.sc.util.DerbyDataLoader;

@Repository
public class OrderDetailDAOImpl implements OrderDetailDAO{

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<OrderDetail> getAllOrderDetails() {
		
		Session session = sessionFactory.openSession();
		
		List<OrderDetail> orderDetails = session.createQuery("from OrderDetail").list();
		
		session.close();
		
		return orderDetails;
	}
	
	
//	public static void main(String[] args){
//		OrderDetailDAOImpl impl = new OrderDetailDAOImpl(); 
//		System.out.println(impl.getAllOrderDetails());
//	}

}
