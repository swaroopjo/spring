package com.lio.sc.dao;

import java.util.List;

import com.lio.sc.beans.Product;

public interface ProductDAO {

	public List<Product> getAllProducts();
	public Product getProductById(Long id);
	public List<Product> getProductsByName(String productName);
	public void addNewProduct(Product product);
	public void deleteProduct(Long id);
}
