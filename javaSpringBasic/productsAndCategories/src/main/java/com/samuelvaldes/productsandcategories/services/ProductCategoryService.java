package com.samuelvaldes.productsandcategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samuelvaldes.productsandcategories.models.Category;
import com.samuelvaldes.productsandcategories.models.Product;
import com.samuelvaldes.productsandcategories.models.ProductCategory;
import com.samuelvaldes.productsandcategories.repositories.ProductCategoryRepository;

@Service
public class ProductCategoryService {

	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------
	
	private final ProductCategoryRepository productCategoryRepository;
	
	
	public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
		this.productCategoryRepository = productCategoryRepository;
		
	}
	
	// ------------------------------------------------
	// II) CRUD methods for Controller class 
	// ------------------------------------------------
	
	// i) CREATE METHODS
	
	// Creates a category
	public ProductCategory createProductCategory(ProductCategory newProductCategory) {
		
		System.out.println("From Service: " + newProductCategory.getId());
		return this.productCategoryRepository.save(newProductCategory);
	}
	
	// ii) READ METHODS
	
	// Retrieves all relationships between products and categories
		public List<ProductCategory> findAllProductCategories() {
			return this.productCategoryRepository.findAll();
		}
	
	// iv) DELETE METHODS
	
	// Creates a category
	public void removeProductCategory(Long id) {
		
		System.out.println(id);
		
		this.productCategoryRepository.deleteById(id);
	}
	
}
