package com.app.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.demo.model.Product;
import com.app.demo.service.CategoryService;
import com.app.demo.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	 @GetMapping("/product")
	 public String create(Model model) {
		 System.out.println(" product get method");
		 model.addAttribute("product",new Product());
		 model.addAttribute("categories",categoryService.findAll());
		 return "product-form";
	 }
	 
	 @PostMapping("/product")
	 public String process(@Valid Product product,BindingResult result) {
		 System.out.println(" product post method"+product.toString());
		 if(result.hasErrors()) {
			 System.out.println("has error");
			 return "product-form";
		 }
		 productService.creaate(product);
		 System.out.println("successfully saved ! ");
		 return "redirect:/products";
	 }
	 
	 @GetMapping("/products")
	 public String showAllProducts(Model model) {
		 System.out.println("product get method");
		 model.addAttribute("products",productService.findAll());
		 return "products";
	 }

}
