package com.lio.sc.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long orderID;
	private Long customerID; 
	private Long employeeId; 
	private String orderDate; 
	private Long shipperId;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ORDERID", unique = true, nullable = false)
	public Long getOrderID() {
		return orderID;
	}
	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}
	
	@Column(name = "CUSTOMERID", unique = false, nullable = false)
	public Long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}
	@Column(name = "EMPLOYEEID", unique = false, nullable = false)
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	@Column(name = "ORDERDATE", unique = false, nullable = false)
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	@Column(name = "SHIPPERID", unique = false, nullable = false)
	public Long getShipperId() {
		return shipperId;
	}
	public void setShipperId(Long shipperId) {
		this.shipperId = shipperId;
	}
	
	
}
