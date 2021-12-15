package com.maduranga.posbackend.dao;

import org.springframework.data.repository.CrudRepository;

import com.maduranga.posbackend.model.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryRepo extends CrudRepository<Category, String> {

}
