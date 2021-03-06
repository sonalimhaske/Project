package com.ecommerce.shoppingwebsite.controller;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.shoppingwebsite.dao.ProductDao;
import com.ecommerce.shoppingwebsite.entity.Category;
import com.ecommerce.shoppingwebsite.entity.Product;
import com.ecommerce.shoppingwebsite.service.CategoryService;
import com.ecommerce.shoppingwebsite.service.ProductService;

@Controller
public class AdminController {
	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@GetMapping("/admin")
	public String adminHome() {
		return "adminHome";
		}
	@GetMapping("/admin/categories")
	public String getCategories(Model model) {
		model.addAttribute("categories",categoryService.getAllCategory());
		return "categories";
	}
	
	@GetMapping("/admin/categories/add")
	public String getCategoriesAdd(Model model){
		model.addAttribute("category",new Category());
		return "categoriesAdd";
	}
	
	@PostMapping("/admin/categories/add")
	public String postCategoriesAdd(@ModelAttribute("categories")Category category){
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}
	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCat(@PathVariable int id) {
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
	}
	@GetMapping("/admin/categories/update/{id}")
	public String updateCat(@PathVariable int id,Model model) {
		Optional<Category> category = categoryService.getCategoryById(id);
		if(category.isPresent()) {
			model.addAttribute("category",new Category());
			return "categoriesAdd";
		}else
			return "404";
	}
	//Product Section
	@GetMapping("/admin/products")
	public String products(Model model) {
		model.addAttribute("products", productService.getAllProduct());
		//model.addAttribute("products",productService.getAllProduct());
		return "products";
	}
	@GetMapping("/admin/products/add")
	public String productAddGet(Model model) {
		model.addAttribute("productDao", new ProductDao());
		//model.addAttribute("productDao",new ProductDao());
		model.addAttribute("categories",categoryService.getAllCategory());
		return "productsAdd";

	}
	
	@PostMapping("/admin/products/add")
	public String productAddPost(@ModelAttribute("productDao") ProductDao productDao,
			                     @RequestParam("productImage")MultipartFile file, 
			                     @RequestParam("imgName")String imgName ) throws IOException {
		
	Product product	=new Product();
	product.setId(productDao.getId());
	product.setName(productDao.getName());
	product.setCategory(categoryService.getCategoryById(productDao.getCategoryId()).get());
	product.setPrice(productDao.getPrice());
	product.setWeight(productDao.getWeight());
	product.setDescription(productDao.getDescription());
	String imageUUID;
	if(!file.isEmpty()) {
			imageUUID =file.getOriginalFilename();
			Path fileNameAndPath=Paths.get(uploadDir,imageUUID);
			Files.write(fileNameAndPath,file.getBytes());
		} else {
				imageUUID=imgName;
			}
		product.setImageName(imageUUID);
		productService.addProduct(product);
		
		return "redirect:/admin/products";
		
	}
	
	@GetMapping("/admin/product/delete/{id}")
	public String deleteProduct(@PathVariable long id) {
		productService.removeProductById(id);
		return "redirect:/admin/products";
}
@GetMapping("/admin/product/update/{id}")
public String updateProductGet(@PathVariable long id, Model model) {
	Product product= productService.getProductById(id).get();
	ProductDao productDao =new ProductDao();
	productDao.setId(product.getId());
	productDao.setName(product.getName());
	productDao.setCategoryId((product.getCategory().getId()));
	productDao.setPrice(product.getPrice());
	productDao.setWeight(product.getWeight());
	productDao.setDescription(product.getDescription());
	productDao.setImageName(product.getImageName());
	
	model.addAttribute("categories",categoryService.getAllCategory());
	model.addAttribute("productDao",productDao);
	return "productsAdd";
}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
