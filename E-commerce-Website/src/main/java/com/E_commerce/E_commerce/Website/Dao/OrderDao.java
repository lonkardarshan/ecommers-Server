package com.E_commerce.E_commerce.Website.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.E_commerce.E_commerce.Website.Entity.Orders;

@Repository
public class OrderDao {

	@Autowired
	SessionFactory sf;

	public boolean addOrder(Orders order) {
		Session s = sf.openSession();
		try {
			s.save(order);
			s.beginTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}

	public List<Orders> getAllOrder(String email) {
		Session s = sf.openSession();
		try {
			Query<Orders> query = s.createQuery("from Orders where email=:email");
			query.setParameter("email", email);
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

	public List<Orders> getAllOrder() {
		Session s = sf.openSession();
		try {
			Query<Orders> query = s.createQuery("from Orders");
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

	public boolean updateorder(Orders order) {
		Session s = sf.openSession();
		try {
			s.update(order);
			s.beginTransaction().commit();
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
