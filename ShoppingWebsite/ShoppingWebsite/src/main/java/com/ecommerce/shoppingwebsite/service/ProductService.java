package com.ecommerce.shoppingwebsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shoppingwebsite.entity.Category;
import com.ecommerce.shoppingwebsite.entity.Product;
import com.ecommerce.shoppingwebsite.repository.ProductRepository;
@Service
public class ProductService {
@Autowired
ProductRepository productRepository;
	public List<Product> getAllProduct(){ 
		return productRepository.findAll();
		}
	public void addProduct(Product product) { 
		productRepository.save(product); 
		}
	public void removeProductById(long id) {
		productRepository.deleteById(id);
		}
	public Optional<Product> getProductById(long id) {
		return productRepository.findById(id); 
	}
	
	public List<Product> getAllProductByCategoryId(int id) {
		return productRepository.findAllByCategory_Id(id);
	}
	
	
}
