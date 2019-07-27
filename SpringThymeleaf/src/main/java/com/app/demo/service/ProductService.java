package com.app.demo.service;

import java.util.List;

import com.app.demo.model.Product;

public interface ProductService {

	Product creaate(Product product);
	
	List<Product> findAll();
	
	Product findById(int id);
}
