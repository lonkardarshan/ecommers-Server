package com.E_commerce.E_commerce.Website.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_commerce.E_commerce.Website.Dao.OrderDao;

import com.E_commerce.E_commerce.Website.Entity.Orders;

@Service
public class OrderService {

	@Autowired
	OrderDao dao;

	public boolean addOrder(Orders order) {

		return dao.addOrder(order);
	}

	public List<Orders> getAllOrder(String email) {
		return dao.getAllOrder(email);

	}

	public List<Orders> getAllOrder() {
		return dao.getAllOrder();

	}

	public boolean updateorder(Orders order) {
		return dao.updateorder(order);
	}
}
