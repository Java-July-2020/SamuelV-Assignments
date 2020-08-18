package com.samuelvaldes.productsandcategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samuelvaldes.productsandcategories.models.Category;
import com.samuelvaldes.productsandcategories.models.Product;
import com.samuelvaldes.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------
	
	private final CategoryRepository categoryRepository;
	
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
		
	}
	
	// ------------------------------------------------
	// II) CRUD methods for Controller class 
	// ------------------------------------------------
	
	// i) CREATE METHODS
		
	// Creates a category
	public Category createCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	
	// ii) READ METHODS
	
	// Retrieves all categories
	public List<Category> getAllCategories() {
		return this.categoryRepository.findAll();
	}
	
	// Retrieves a category by id
	public Category findCategoryById(Long id) {
		return this.categoryRepository.findById(id).orElse(null);
	}
	
	// Retrieves all categories that a specific product has not been categorized yet
	public List<Category> findCategoriesNotInProduct(Product product) {
		return this.categoryRepository.findByProductsNotContains(product);
	}
	
	// iii) UPDATE METHODS
	
	// Add new Product to a Category
	public void addProductToCategory(Category category, Product product) {
		// get Product list from the Category
		List<Product> products = category.getProducts();
		// Add selected Category to Product
		products.add(product);
		// Update DB
		this.categoryRepository.save(category);
	}
	
	// iv) DELETE METHODS
	
	// Deletes a category by id
	public void deleteCategory(Long id) {
		this.categoryRepository.deleteById(id);
	}
}
