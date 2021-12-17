package com.maduranga.posbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maduranga.posbackend.model.Category;
import com.maduranga.posbackend.model.Product;
import com.maduranga.posbackend.service.CategoryService;

@RestController
@RequestMapping("v1/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/all")
	public ResponseEntity<List<Category>> getAllCategories(){
		return categoryService.getAllCategories();
	}

	@GetMapping("/{cid}")
	public ResponseEntity<Category> findCategories(@PathVariable String cid){
		return categoryService.getCategoryByid(cid);
	}

	@PostMapping("/save")
	public ResponseEntity<Category> saveCategories(@RequestBody Category category){
		return categoryService.insertCategories(category);
	}

	@DeleteMapping("/{cid}")
	public ResponseEntity<Category> deleteCategories(@PathVariable String cid){
		return categoryService.deleteCategories(cid);
	}

	@PutMapping("/{cid}")
	public ResponseEntity<Category> updateCategories(@PathVariable String cid, @RequestBody Category category){
		return categoryService.updateCategories(cid,category);
	}
}
