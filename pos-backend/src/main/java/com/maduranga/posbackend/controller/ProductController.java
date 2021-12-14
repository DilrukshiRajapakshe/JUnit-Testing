package com.maduranga.posbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maduranga.posbackend.model.Product;
import com.maduranga.posbackend.service.ProductService;

@CrossOrigin()
@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping("/products")
	public List<Product> getAllproducts() {
		return productService.getAllProducts();
	}

	@RequestMapping("/category/{id}/products")
	public List<Product> getAllproductsbyCategory(@PathVariable String id) {
		return productService.getAllProductsByCategory(id);
	}

	@RequestMapping("/products/{id}")
	public Optional<Product> getProduct(@PathVariable String id) {
		return productService.getProductByid(id);
	}
}
