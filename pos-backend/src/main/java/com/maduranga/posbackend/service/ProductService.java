package com.maduranga.posbackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maduranga.posbackend.dao.ProductRepo;
import com.maduranga.posbackend.model.Product;
import com.maduranga.posbackend.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	public ResponseEntity<List<Product>> getAllProduct() {
		try {
			List<Product> productList = new ArrayList<Product>();
			productRepo.findAll().forEach(productList::add);
			return new ResponseEntity<>(productList, HttpStatus.OK);
		} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity insertProduct(Product product) {
		try {
			return new ResponseEntity<>(productRepo.save(product), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity deleteProduct(String pid) {
		try {
			productRepo.deleteById(pid);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity updateProduct(String pid, Product product) {
		Optional<Product> categories  = productRepo.findById(pid);
		if(categories.isPresent())
			return new ResponseEntity<>(productRepo.save(product), HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<Product> getProductByid(String pid) {
		Optional<Product> categories = productRepo.findById(pid);
		if (categories.isPresent()) {
			return new ResponseEntity<>(categories.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
