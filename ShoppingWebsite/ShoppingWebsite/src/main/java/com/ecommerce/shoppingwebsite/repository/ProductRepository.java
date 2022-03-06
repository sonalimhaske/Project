package com.ecommerce.shoppingwebsite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.shoppingwebsite.entity.Product;

public interface ProductRepository extends JpaRepository <Product,Long>  {
	
List<Product> findAllByCategory_Id(int id);



}
