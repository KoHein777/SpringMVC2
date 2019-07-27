package com.app.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.model.Category;
import com.app.demo.repostory.CategoryRepository;

@Service
public class CategoryServImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public Category findById(int id) {
		 return categoryRepo.findById(id).orElseThrow(()-> new EntityNotFoundException(id + " not found "));
	
	}

	@Override
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}

	@Override
	public Category create(Category category) {
		return categoryRepo.save(category);
	}

}
