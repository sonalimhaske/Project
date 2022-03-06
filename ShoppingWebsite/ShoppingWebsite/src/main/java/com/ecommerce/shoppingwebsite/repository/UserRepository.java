package com.ecommerce.shoppingwebsite.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.shoppingwebsite.entity.User;

public interface UserRepository extends JpaRepository <User, Integer> {

	Optional<User> findUserByEmail(String email);

	

}
