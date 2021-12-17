package com.maduranga.posbackend.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.maduranga.posbackend.model.Product;

public interface ProductRepo extends CrudRepository<Product, String>{

	//public List<Product> findByCategoryCid(String cid);
	
}
