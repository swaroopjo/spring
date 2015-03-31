package com.lio.sc.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long productId; 
	private String productName; 
	private Long supplierId; 
	private Long categoryId; 
	private String unit; 
	private Double price;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PRODUCTID", unique = true, nullable = false)
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	@Column(name = "PRODUCTNAME", unique = false, nullable = false, length = 50)
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Column(name = "SUPPLIERID", unique = false, nullable = false)
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	@Column(name = "CATEGORYID", unique = false, nullable = false)
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	@Column(name = "UNIT", unique = false, nullable = false, length = 50)
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Column(name = "PRICE", unique = false, nullable = false)
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", supplierId=" + supplierId + ", categoryId="
				+ categoryId + ", unit=" + unit + ", price=" + price + "]";
	} 
	
}
