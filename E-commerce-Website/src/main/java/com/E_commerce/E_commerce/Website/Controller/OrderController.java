package com.E_commerce.E_commerce.Website.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.E_commerce.E_commerce.Website.Entity.Orders;
import com.E_commerce.E_commerce.Website.Service.OrderService;

@RestController
@CrossOrigin("http://localhost:4200")
public class OrderController {

	@Autowired
	OrderService service;

	@PostMapping("addOrder")
	public boolean addOrder(@RequestBody Orders order) {
		return service.addOrder(order);
	}
	
	@GetMapping("getAllOrder/{email}")
	public List<Orders> getAllOrder(@PathVariable String email) {
		return service.getAllOrder(email);
	}
	@GetMapping("getAllOrder")
	public List<Orders> getAllOrder() {
		return service.getAllOrder();
	}
	@PutMapping("updateorder")
	public boolean updateorder(@RequestBody Orders order) {
		return service.updateorder(order);
	}
}
