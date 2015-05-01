package com.lio.loan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "loan_user_role")
public class UserRole {

	
			
		private Long id; 
		private Long role; 
		private Long user_id;
		
		@Id
		@GeneratedValue(strategy = IDENTITY)
		@Column(name = "id", unique = true, nullable = false)
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		@Column(name = "role", unique = false, nullable = false)
		public Long getRole() {
			return role;
		}
		public void setRole(Long role) {
			this.role = role;
		}
		@Column(name = "user_id", unique = false, nullable = false)
		public Long getUser_id() {
			return user_id;
		}
		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}
		
}
