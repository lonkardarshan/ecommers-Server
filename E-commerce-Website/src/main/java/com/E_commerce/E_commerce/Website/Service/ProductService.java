package com.E_commerce.E_commerce.Website.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_commerce.E_commerce.Website.Dao.ProductDao;
import com.E_commerce.E_commerce.Website.Entity.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao dao;

	public boolean addProduct(Product product) {
		if (product != null) {
			return dao.addProduct(product);
		}
		return false;
	}

	public List<Product> getAllProduct() {
		return dao.getAllProduct();
	}

	public boolean deleteProduct(int id) {

		return dao.deleteProduct(id);
	}

	public Product getProductById(int id) {
		return dao.getProductById(id);
	}

	public boolean saveProductChanges(Product product) {
		return dao.saveProductChanges(product);
	}

}
