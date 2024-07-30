package com.E_commerce.E_commerce.Website.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.E_commerce.E_commerce.Website.Entity.CartItem;

@Repository
public class CartDao {

	@Autowired
	SessionFactory sf;

	public boolean addToCart(CartItem item) {
		Session s=sf.openSession();
		try {
		String hql = "FROM CartItem WHERE pid = :pid AND email = :email";
        Query<CartItem> query = s.createQuery(hql, CartItem.class);
        query.setParameter("pid", item.getPid());
        query.setParameter("email", item.getEmail());
        CartItem existingItem = query.uniqueResult();
        
		
        if (existingItem != null) {
        	existingItem.setQuantity(existingItem.getQuantity() + 1);
            s.saveOrUpdate(existingItem);
        }else {
        	s.save(item);
        }
		
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

	public List<CartItem> getCatItem(String email) {
		Session s=sf.openSession();
		try {
		Query<CartItem> query=s.createQuery("from CartItem where email = :email");
		query.setParameter("email", email);
		return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (s != null) {
		        s.close();
		    }
		}
		return null;
		
	}

	public boolean deleteCartItem(int id) {
		try{
			Session s=sf.openSession();
		CartItem item= s.load(CartItem.class, id);
		if(item!=null) {
		s.delete(item);
		s.beginTransaction().commit();
		s.close();
		return true;
		}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	
	public boolean  deleteCartItem(String email) {
	    Session s = sf.openSession();
	    Transaction tx = null;
	    try {
	        tx = s.beginTransaction();
	        Query query = s.createQuery("delete from CartItem where email = :email");
	        query.setParameter("email", email);
	        query.executeUpdate();
	        tx.commit();
	        return true;
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	            return false;
	        }
	        e.printStackTrace();
	    } finally {
	        s.close();
	    }
		return false;
	}

	



}
