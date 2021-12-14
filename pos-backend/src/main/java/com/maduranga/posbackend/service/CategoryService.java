package com.maduranga.posbackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maduranga.posbackend.dao.CategoryRepo;
import com.maduranga.posbackend.model.Category;


@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<>();
		categoryRepo.findAll().forEach(categories::add);
		return categories;
	}
	
	public Optional<Category> getCategoryByid(String cid) {
		return categoryRepo.findById(cid);
	}
}
