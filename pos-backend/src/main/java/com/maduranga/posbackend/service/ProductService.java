package com.maduranga.posbackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maduranga.posbackend.dao.ProductRepo;
import com.maduranga.posbackend.model.Category;
import com.maduranga.posbackend.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		productRepo.findAll().forEach(products::add);
		return products;
	}

	public List<Product> getAllProductsByCategory(String catid) {
		List<Product> products = new ArrayList<>();
		productRepo.findByCategoryCid(catid).forEach(products::add);
		return products;
	}

	public Optional<Product> getProductByid(String pid) {
		return productRepo.findById(pid);
	}

}
