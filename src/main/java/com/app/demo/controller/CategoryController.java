package com.app.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.demo.model.Category;
import com.app.demo.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	public CategoryService categorySer;
	
	 @RequestMapping(value = "/category", method = RequestMethod.GET)
	 public String create(Model model) {
		 model.addAttribute("category",new Category());
		 return "categoryForm";
	 }
	 
	 @RequestMapping(value = "/category", method = RequestMethod.POST)
	 public String process(@Valid Category category,BindingResult result) {
		 if(result.hasErrors()) {
			 return "categoryForm";
		 }
		 categorySer.create(category);
		 
		 return "redirect:/categories";
	 }
	 
	 @RequestMapping(value = "/categories", method = RequestMethod.GET)
	 public String showAllCategories(Model model) {
		 model.addAttribute("categories",categorySer.findAll());
		 return "categories";
		 
	 }
	 

}
