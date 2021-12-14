package com.maduranga.posbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maduranga.posbackend.model.Category;
import com.maduranga.posbackend.model.Product;
import com.maduranga.posbackend.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping("/categories")
	public List<Category> getAllcategories() {
		return categoryService.getAllCategories();

	}
	@RequestMapping("/category/{id}")
	public Optional<Category> getcategory(@PathVariable String id) {
		return categoryService.getCategoryByid(id);
	}
	
}
