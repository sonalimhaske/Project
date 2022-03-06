package com.ecommerce.shoppingwebsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shoppingwebsite.entity.Category;
import com.ecommerce.shoppingwebsite.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
		
	}
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	public void removeCategoryById(int id) {
		categoryRepository.deleteById(id);
	}
	public Optional<Category> getCategoryById(Category category) {
		return categoryRepository.findById(category);
	}
	public Optional<Category> getCategoryById(int id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}
	

}