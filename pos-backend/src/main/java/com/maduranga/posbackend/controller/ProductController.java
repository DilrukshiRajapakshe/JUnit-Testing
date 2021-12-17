package com.maduranga.posbackend.controller;

import java.util.List;
import java.util.Optional;

import com.maduranga.posbackend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maduranga.posbackend.model.Product;
import com.maduranga.posbackend.service.ProductService;

@CrossOrigin()
@RestController
@RequestMapping("v1/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProduct(){
		return productService.getAllProduct();
	}

	@GetMapping("/{pid}")
	public ResponseEntity<Product> findProduct(@PathVariable String pid){
		return productService.getProductByid(pid);
	}

	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return productService.insertProduct(product);
	}

	@DeleteMapping("delete/{pid}")
	public ResponseEntity<Product> deleteProduct(@PathVariable String pid){
		return productService.deleteProduct(pid);
	}

	@PutMapping("update/{pid}")
	public ResponseEntity<Product> updateProduct(@PathVariable String pid, @RequestBody Product product){
		return productService.updateProduct(pid,product);
	}
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}
