package com.maduranga.posbackend.dao;

import org.springframework.data.repository.CrudRepository;

import com.maduranga.posbackend.model.Category;

public interface CategoryRepo extends CrudRepository<Category, String> {

}
