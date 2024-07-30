package com.E_commerce.E_commerce.Website.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.E_commerce.E_commerce.Website.Entity.Product;
import com.E_commerce.E_commerce.Website.Service.ProductService;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping("addProduct")
	public boolean addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	@GetMapping("getAll")
	public List<Product> getAllProduct(){
		return service.getAllProduct();
	}
	@DeleteMapping("deleteProduct/{id}")
	public boolean deleteProduct(@PathVariable int id){
		return service.deleteProduct(id);
	}
	@GetMapping("getProductById/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.getProductById(id);
	}
	@PutMapping("saveProductChanges")
	public boolean saveProductChanges(@RequestBody Product product) {
		return service.saveProductChanges(product);
	}
}
