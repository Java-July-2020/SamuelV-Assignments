package com.samuelvaldes.productsandcategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samuelvaldes.productsandcategories.models.Category;
import com.samuelvaldes.productsandcategories.models.Product;
import com.samuelvaldes.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------
	
	private final ProductRepository productRepository;
	
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
		
	}
	
	// ------------------------------------------------
	// II) CRUD methods for Controller class 
	// ------------------------------------------------
	
	// i) CREATE METHODS
	
	// Creates a product
	public Product createProduct(Product product) {
		return this.productRepository.save(product);
	}
		
	// ii) READ METHODS
	
	// Retrieves all products
	public List<Product> getAllProducts() {
		return this.productRepository.findAll();
	}

	// Retrieves a product by id
	public Product findProductById(Long id) {
		return this.productRepository.findById(id).orElse(null);
	}
	
	// Retrieves all products that are not categorized to a specific category
	public List<Product> findProductsNotInCategory(Category category) {
		return this.productRepository.findByCategoriesNotContains(category);
	}
	
	// iii) UPDATE METHODS
	
	// Add new Category to a Product
	public void addCategoryToProduct(Product product, Category category) {
		// get Category list from the Product
		List<Category> categories = product.getCategories();
		// Add selected Category to Product
		categories.add(category);
		// Update DB
		this.productRepository.save(product);
	}
	
	// iv) DELETE METHODS
	
	// Deletes a product by id
	public void deleteProduct(Long id) {
		this.productRepository.deleteById(id);
	}

}
