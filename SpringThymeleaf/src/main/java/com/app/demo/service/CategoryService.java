package com.app.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.demo.model.Category;


public interface CategoryService {
	
	Category create(Category category);
	Category findById(int id);
	List<Category> findAll();
	


}
