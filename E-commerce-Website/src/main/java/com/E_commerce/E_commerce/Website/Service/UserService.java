package com.E_commerce.E_commerce.Website.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_commerce.E_commerce.Website.Dao.UserDao;
import com.E_commerce.E_commerce.Website.Entity.User;

@Service
public class UserService {
	@Autowired
	UserDao dao;

	public boolean addUser(User user) {
		if (user != null) {
			return dao.addUser(user);
		}
		return false;
	}

	public User login(String email) {
		try {

			User user = dao.login(email);
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	public List<User> getAllUser() {
		return dao.getAllUser();
	}

	public boolean deleteUser(String email) {
		return dao.deleteUser(email);
	}
}
