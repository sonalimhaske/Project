package com.ecommerce.shoppingwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.shoppingwebsite.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {

}
