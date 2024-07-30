package com.E_commerce.E_commerce.Website.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.E_commerce.E_commerce.Website.Entity.User;

@Repository
public class UserDao {

	@Autowired
	SessionFactory sf;

	public boolean addUser(User user) {
		Session s = sf.openSession();
		try {
			Transaction t = s.beginTransaction();
			s.save(user);
			t.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
			}
		}
		return false;
	}

	public User login(String email) {
		Session s = sf.openSession();
		try {
			User user = (User) s.get(User.class, email);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return null;

	}

	public List<User> getAllUser() {
		Session s = sf.openSession();
		try {
			Query<User> query = s.createQuery("from User");
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
			}
		}
		return null;
	}

	public boolean deleteUser(String email) {
		Session s = sf.openSession();
		try {
			User user = s.load(User.class, email);
			s.delete(user);
			s.beginTransaction().commit();
			s.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
			}
		}
		return false;

	}
}
