package com.lio.sc.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "CUSTOMERS")
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long customerID;
	private String customerName; 
	private String contactName; 
	private String address;
	private String city; 
	private String postalCode; 
	private String country;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CUSTOMERID", unique = true, nullable = false)
	public Long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}
	
	@Column(name = "CUSTOMERNAME", unique = false, nullable = false, length = 50)
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Column(name = "CONTACTNAME", unique = false, nullable = false, length = 50)
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	@Column(name = "ADDRESS", unique = false, nullable = false, length = 50)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "CITY", unique = false, nullable = false, length = 50)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "POSTALCODE", unique = false, nullable = false, length = 50)
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	@Column(name = "COUNTRY", unique = false, nullable = false, length = 50)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName="
				+ customerName + ", contactName=" + contactName + ", address="
				+ address + ", city=" + city + ", postalCode=" + postalCode
				+ ", country=" + country + "]";
	}
	
}
