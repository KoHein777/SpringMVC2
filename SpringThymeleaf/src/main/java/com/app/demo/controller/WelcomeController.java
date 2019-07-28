package com.app.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.demo.model.Category;
import com.app.demo.service.CategoryService;

@Controller
public class WelcomeController {
	
	@Autowired
	private CategoryService categoryService;
	
 @RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
	 System.out.println("home get method");
		model.addAttribute("message","Welcome Spring MVC");
		return "home";
		
	}
 

 @RequestMapping("/about")
 public String about() {
	 System.out.println("about get method");
     return "about";
 }
 
 @GetMapping("/category")
 public String create(Model model) {
	 System.out.println(" category get method");
	 model.addAttribute("category",new Category());
	 return "category-form";
 }
 
 @PostMapping("/category")
 public String process(@Valid Category category,BindingResult result) {
	 System.out.println("category post method");
	 if(result.hasErrors()) {
		 return "category-form";
	 }
	 categoryService.create(category);
	 return "redirect:/categories";
 }
 
 @GetMapping("/categories")
 public String showAllCategories(Model model) {
	 System.out.println("categories get method");
	 model.addAttribute("categories",categoryService.findAll());
	 return "categories";
 }

}
