package com.app.demo.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
