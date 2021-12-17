package com.maduranga.posbackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maduranga.posbackend.dao.CategoryRepo;
import com.maduranga.posbackend.model.Category;


@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	public ResponseEntity<List<Category>> getAllCategories() {
		try {
			List<Category> categoryList = new ArrayList<Category>();
			categoryRepo.findAll().forEach(categoryList::add);
			return new ResponseEntity<>(categoryList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity insertCategories(Category category) {
		try {
			return new ResponseEntity<>(categoryRepo.save(category), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity deleteCategories(String cid) {
		try {
			categoryRepo.deleteById(cid);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity updateCategories(String cid, Category category) {
		Optional<Category> categories  = categoryRepo.findById(cid);
		if(categories.isPresent())
			return new ResponseEntity<>(categoryRepo.save(category), HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<Category> getCategoryByid(String cid) {
		Optional<Category> categories = categoryRepo.findById(cid);
		if (categories.isPresent()) {
			return new ResponseEntity<>(categories.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
