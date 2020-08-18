package com.samuelvaldes.productsandcategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samuelvaldes.productsandcategories.models.ProductCategory;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long>{

}
