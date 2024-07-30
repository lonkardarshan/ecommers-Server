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

import com.E_commerce.E_commerce.Website.Entity.User;
import com.E_commerce.E_commerce.Website.Service.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {
@Autowired
UserService service;
	
	@PostMapping("addUser")
	public boolean addUser(@RequestBody User user) {
	
		return service.addUser(user);
	}
	@PostMapping("login/{email}")
	public User login(@PathVariable String email) {
		return service.login(email);
		
	}
	
	@GetMapping("getAllUser")
	public List<User> getAllUser() {
		return service.getAllUser();
	}
	@DeleteMapping("deleteUser/{email}")
	public boolean deleteUser(@PathVariable String email) {
		return service.deleteUser(email);
	}
}

