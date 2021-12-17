package com.maduranga.posbackend.controller;

import java.util.List;
import com.maduranga.posbackend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maduranga.posbackend.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProduct(){
		return productService.getAllProduct();
	}

	@RequestMapping(value = "/{pid}", method = RequestMethod.GET)
	public ResponseEntity<Product> findProduct(@PathVariable String pid){
		return productService.getProductByid(pid);
	}

	@RequestMapping(value ="/save", method = RequestMethod.POST)
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return productService.insertProduct(product);
	}

	@RequestMapping(value = "/{pid}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteProduct(@PathVariable String pid){
		return productService.deleteProduct(pid);
	}

	@RequestMapping(value ="/{pid}", method = RequestMethod.PUT )
	public ResponseEntity<Product> updateProduct(@PathVariable String pid, @RequestBody Product product){
		return productService.updateProduct(pid,product);
	}
	@RequestMapping("/hello")
	public String hello() {
		return "Dilrukshi";
	}
}
