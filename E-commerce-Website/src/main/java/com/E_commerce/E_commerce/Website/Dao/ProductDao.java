package com.E_commerce.E_commerce.Website.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.E_commerce.E_commerce.Website.Entity.Product;

@Repository
public class ProductDao {

	@Autowired
	SessionFactory sf;
	
	
	public boolean addProduct(Product product) {
		Session s=sf.openSession();
		try {
		s.save(product);
		s.beginTransaction().commit();
		return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(s!=null) {
				s.close();
			}
		}
	}


	public List<Product> getAllProduct() {
		Session s=sf.openSession();
		try {
		Query<Product> query=s.createQuery("from Product");
		return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(s!=null) {
				s.close();
			}
		}
		return null;
	}


	public boolean deleteProduct(int id) {
		Session s=sf.openSession();
		try{
		Product p=s.load(Product.class, id);
		s.delete(p);
		s.beginTransaction().commit();
		s.close();
		return true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(s!=null) {
				s.close();
			}
		}
		return false;
		
	}


	public Product getProductById(int id) {
		Session s=sf.openSession();
		try {
			Product product=s.get(Product.class, id);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(s!=null) {
				s.close();
			}
		}
		return null;
	}


	public boolean saveProductChanges(Product product) {
		Session s=sf.openSession();
		try {
			s.update(product);
			s.beginTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(s!=null) {
				s.close();
			}
		}
		return false;
	}
	
}
