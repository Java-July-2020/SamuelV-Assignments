package com.samuelvaldes.productsandcategories.services;

import org.springframework.stereotype.Service;

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
	public ProductCategory createProductCategory(ProductCategory productCategory) {
		System.out.println(this.productCategoryRepository.save(productCategory));
		return this.productCategoryRepository.save(productCategory);
	}
}
