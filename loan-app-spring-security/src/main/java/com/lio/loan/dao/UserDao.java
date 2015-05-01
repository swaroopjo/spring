package com.lio.loan.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lio.loan.domain.AppUser;
import com.lio.loan.domain.UserRole;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public AppUser findUserByLoginID(String loginName){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM AppUser WHERE loginName = :name");
		query.setParameter("name", loginName);
		
		AppUser user = (AppUser)query.list().get(0);
		
		session.close(); 
		
		return user;
		
	}
	
	public UserRole findUserRoleByUserID(Long id){
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UserRole where user_id= :userId");
		query.setParameter("userId", id);
		UserRole userRole = (UserRole)query.list().get(0);
		session.close();
		
		return userRole;
	}
}
