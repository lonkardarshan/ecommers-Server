package com.E_commerce.E_commerce.Website.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.E_commerce.E_commerce.Website.Entity.CartItem;
import com.E_commerce.E_commerce.Website.Service.CartService;

@RestController
@CrossOrigin("http://localhost:4200")
public class CartController {

	@Autowired
	CartService service;

	@PostMapping("addToCart")
	public boolean addToCart(@RequestBody CartItem item) {
		return service.addToCart(item);
	}

	@GetMapping("getCatItem/{email}")
	public List<CartItem> getCatItem(@PathVariable String email) {
		return service.getCatItem(email);
	}

	@DeleteMapping("deleteCartItem/{id}")
	public boolean deleteCartItem(@PathVariable int id) {
		return service.deleteCartItem(id);
	}

	@DeleteMapping("deleteCartItemByEmail/{email}")
	public boolean deleteCartItem(@PathVariable String email) {
		return service.deleteCartItem(email);

	}
}
