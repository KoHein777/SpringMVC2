package com.app.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.model.Product;
import com.app.demo.repostory.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepo productRepo;
	

	@Override
	public Product creaate(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	@Override
	public Product findById(int id) {
		return productRepo.findById(id).orElseThrow(()-> new EntityNotFoundException(id+" not found"));
	}

}
