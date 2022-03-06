package com.ecommerce.shoppingwebsite.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.shoppingwebsite.entity.Role;
import com.ecommerce.shoppingwebsite.entity.User;
import com.ecommerce.shoppingwebsite.global.GlobalData;
import com.ecommerce.shoppingwebsite.repository.RoleRepository;
import com.ecommerce.shoppingwebsite.repository.UserRepository;

@Controller
public class LoginController {
	//@Autowired
	//public BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	UserRepository userRepository;
@Autowired
RoleRepository roleReposetory;

@GetMapping("/login")
public String login() {
	GlobalData.cart.clear();
	return"login";
}
@GetMapping("/register")
public String registerGet() {
	return"register";
}

@PostMapping("/register")
public String registerPost(@ModelAttribute("user")User user,HttpServletRequest request ) throws ServletException{
	String password =user.getPassword();
	//user.setPassword(bCryptPasswordEncoder.encode(password));
	List<Role>roles=new ArrayList<>();
	//roles.add(rolepository.findById(2).get());
	user.setRoles(roles);
	userRepository.save(user);
	request.login(user.getEmail(), password);
	return "redirct:/";
	
}

}
