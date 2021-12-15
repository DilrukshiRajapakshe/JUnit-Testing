package com.maduranga.posbackend.controller;

import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import com.maduranga.posbackend.model.Category;
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

	@DeleteMapping("/{pid}")
	public ResponseEntity<Product> deleteProduct(@PathVariable String pid){
		return productService.deleteProduct(pid);
	}

	@PutMapping("/{pid}")
	public ResponseEntity<Product> updateProduct(@PathVariable String pid, @RequestBody Product product){
		return productService.updateProduct(pid,product);
	}
	@RequestMapping("/hello")
	public String hello() {
//		Product p = new Product();
//		p.setPid("m0011");
//		p.setPname("SamS Chicken Sausage 200G");
//		p.setPdesc("Sausages");
//		p.setPprice(500.00);
//		p.setPimgurl("https://objectstorage.ap-mumbai-1.oraclecloud.com/n/softlogicbicloud/b/cdn/o/products/600-600/118606--01--1613335103.jpeg");
//		p.setCategory(new Category("M1", "Meet Products"));
//
//		String jsonString = new Gson().toJson((p));
//		System.out.println(jsonString);
//		System.out.println(jsonContext.read());
		return "Dilrukshi";
	}
}
