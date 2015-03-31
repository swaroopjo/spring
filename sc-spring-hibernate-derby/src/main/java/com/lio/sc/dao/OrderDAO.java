package com.lio.sc.dao;

import java.util.List;

import com.lio.sc.beans.Order;
import com.lio.sc.beans.Product;

public interface OrderDAO {

	public List<Order> getAllOrders();
	
}
