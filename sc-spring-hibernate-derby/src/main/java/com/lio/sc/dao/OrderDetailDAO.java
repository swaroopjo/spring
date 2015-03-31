package com.lio.sc.dao;

import java.util.List;

import com.lio.sc.beans.OrderDetail;
import com.lio.sc.beans.Product;

public interface OrderDetailDAO {

	public List<OrderDetail> getAllOrderDetails();
	
}
