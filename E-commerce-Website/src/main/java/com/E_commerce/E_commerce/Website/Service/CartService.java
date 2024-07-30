package com.E_commerce.E_commerce.Website.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_commerce.E_commerce.Website.Dao.CartDao;
import com.E_commerce.E_commerce.Website.Entity.CartItem;

@Service
public class CartService {

	@Autowired
	CartDao dao;

	public boolean addToCart(CartItem item) {
		// TODO Auto-generated method stub
		return dao.addToCart(item);
	}

	public List<CartItem> getCatItem(String email) {
		return dao.getCatItem(email);
	}

	public boolean deleteCartItem(int id) {
		return dao.deleteCartItem(id);
	}

	public boolean deleteCartItem(String email) {
		return dao.deleteCartItem(email);
	}

}
