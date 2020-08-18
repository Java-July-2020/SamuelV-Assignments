package com.samuelvaldes.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samuelvaldes.productsandcategories.models.Category;
import com.samuelvaldes.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	// retrieves all products from the database
    public List<Product> findAll();
    // retrieves all products that are not categorized to a specific category
    List<Product> findByCategoriesNotContains(Category category);
}
