package com.lio.sc.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;//.SpringJUnit4ClassRunner
import com.lio.sc.beans.Customer;
import com.lio.sc.dao.CustomerDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-hibernate.xml")
public class CustomerIntegTest {

	@Autowired
	private CustomerDAO customerDAOImpl;
	
	@Test
	public void getAllCustomers(){
		List<Customer> customers = customerDAOImpl.getAllCustomers();
		
		for(Customer customer:customers){
			System.out.println(customer);
		}
		
	}

	public CustomerDAO getCustomerDAOImpl() {
		return customerDAOImpl;
	}

	public void setCustomerDAOImpl(CustomerDAO customerDAOImpl) {
		this.customerDAOImpl = customerDAOImpl;
	}
	
	
}
