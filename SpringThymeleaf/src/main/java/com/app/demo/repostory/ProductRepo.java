package com.app.demo.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.model.Product;

@Repository
public interface ProductRepo  extends JpaRepository<Product, Integer>{

}
