package com.lio.loan.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Table(name = "loan_user")
public class AppUser implements Serializable{
	
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private Long id; 
		private String loginName; 
		private String fName; 
		private String lName; 
		private String password;
		
		
		@Id
		@GeneratedValue(strategy = IDENTITY)
		@Column(name = "id", unique = true, nullable = false)
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		@Column(name = "username", unique = false, nullable = false)
		public String getLoginName() {
			return loginName;
		}
		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}
		@Column(name = "firstName", unique = false, nullable = false)
		public String getfName() {
			return fName;
		}
		public void setfName(String fName) {
			this.fName = fName;
		}
		@Column(name = "lastName", unique = false, nullable = false)
		public String getlName() {
			return lName;
		}
		public void setlName(String lName) {
			this.lName = lName;
		}
		@Column(name = "password", unique = false, nullable = false)
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		} 
		
		
}
