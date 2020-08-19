package com.samuelvaldes.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.samuelvaldes.productsandcategories.models.Category;
import com.samuelvaldes.productsandcategories.models.Product;
import com.samuelvaldes.productsandcategories.models.ProductCategory;
import com.samuelvaldes.productsandcategories.services.CategoryService;
import com.samuelvaldes.productsandcategories.services.ProductCategoryService;
import com.samuelvaldes.productsandcategories.services.ProductService;

@Controller
public class MainController {

	
	// ------------------------------------------------
	// I) Attributes and Constructor
	// ------------------------------------------------
	
	private final ProductService productService;
	private final CategoryService categoryService;
	private final ProductCategoryService productCategoryService;
	
	
	public MainController (ProductService productService, CategoryService categoryService, ProductCategoryService productCategoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
		this.productCategoryService = productCategoryService;
	}
	
	// ------------------------------------------------
	// II) Path Request Methods
	// ------------------------------------------------
	
	// 1) DASHBOARD REQUESTS
	
	// GET Request to present Index and all Products and Categories in the database
		@RequestMapping("/dashboard")
		public String index(Model model) {
			List<Product> products = productService.getAllProducts();
			List<Category> categories = categoryService.getAllCategories();
			model.addAttribute("products", products);
			model.addAttribute("categories", categories);
			return "index.jsp";
		}
		
	// 2) PRODUCTS REQUESTS
		
	// GET Request to present form for adding new product
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	// POST Request for adding a new product to the database
	@RequestMapping(value = "/products/new", method=RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}
		else {
			productService.createProduct(product);
			return "redirect:/dashboard";
		}
	}
	
	// GET Request showing the info of a product in detail
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, @ModelAttribute("productCategory") ProductCategory productCategory, Model model) {
		Product productSelected = productService.findProductById(id);
		List <Category> categoriesListed = productSelected.getCategories();
		List <Category> categoriesNotListed = categoryService.findCategoriesNotInProduct(productSelected);
		
		model.addAttribute("product", productSelected);
		model.addAttribute("categoriesListed",categoriesListed);
		model.addAttribute("categoriesNotListed",categoriesNotListed);
		
		return "showProduct.jsp";
	}
	
	// POST Request for adding category to a product
	@RequestMapping(value="/products/addCategory", method=RequestMethod.POST)
	public String addCategoryToProduct(@ModelAttribute("productCategory") ProductCategory productCategory, BindingResult result) {
		
		if(result.hasErrors()) {
			return "showProduct.jsp";
		}
		else {
			productCategoryService.createProductCategory(productCategory);
			Long id = productCategory.getProduct().getId();
			return "redirect:/products/"+id;
		}
				
	}
	
	// POST Request for removing a category from a product
	@RequestMapping(value="/products/removeCategory", method=RequestMethod.POST)
	public String removeCategoryFromProduct(
			@RequestParam(value="product") Product product,
			@RequestParam(value="category") Category category) {
		
		Long idProductCategoryToBeRemoved;
		List <ProductCategory> allProductsCategories = productCategoryService.findAllProductCategories();
		
		
		for (ProductCategory eachAssociation : allProductsCategories) {
			if(eachAssociation.getProduct().getId()==product.getId() &&
				eachAssociation.getCategory().getId()==category.getId()) {
				
				idProductCategoryToBeRemoved = eachAssociation.getId();
				productCategoryService.removeProductCategory(idProductCategoryToBeRemoved);
			}
		}
		
		Long id = product.getId();
		return "redirect:/products/"+id;
		
	}
		
				
	// GET Request for deleting a product
	@RequestMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/dashboard";
    }
	
	// 3) CATEGORIES REQUESTS 
	
	// GET Request to present form for adding new category
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("productCategory") ProductCategory productCategory) {
		return "newCategory.jsp";
	}
	
	// POST Request for adding a new category to the database
	@RequestMapping(value = "/categories/new", method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}
		else {
			categoryService.createCategory(category);
			return "redirect:/dashboard";
		}
	}
	
	// GET Request showing the info of a category in detail
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, @ModelAttribute("productCategory") ProductCategory productCategory, Model model) {
		Category categorySelected = categoryService.findCategoryById(id);
		List <Product> productsListed = categorySelected.getProducts();
		List <Product> productsNotListed = productService.findProductsNotInCategory(categorySelected);
		
		model.addAttribute("category", categorySelected);
		model.addAttribute("productsListed",productsListed);
		model.addAttribute("productsNotListed",productsNotListed);
		return "showCategory.jsp";
	}
	
	// POST Request for adding product to a category
	@RequestMapping(value="/categories/addProduct", method=RequestMethod.POST)
	public String addProductToCategory(@ModelAttribute("productCategory") ProductCategory productCategory, BindingResult result) {
		
		if(result.hasErrors()) {
			return "showCategory.jsp";
		}
		else {
			productCategoryService.createProductCategory(productCategory);
			Long id = productCategory.getProduct().getId();
			return "redirect:/categories/"+id;
		}
				
	}
	
	// POST Request for removing a category from a product
	@RequestMapping(value="/categories/removeProduct", method=RequestMethod.POST)
	public String removeProductFromCategory(
			@RequestParam(value="product") Product product,
			@RequestParam(value="category") Category category) {
		
		Long idProductCategoryToBeRemoved;
		List <ProductCategory> allProductsCategories = productCategoryService.findAllProductCategories();
		
		
		for (ProductCategory eachAssociation : allProductsCategories) {
			if(eachAssociation.getProduct().getId()==product.getId() &&
				eachAssociation.getCategory().getId()==category.getId()) {
				
				idProductCategoryToBeRemoved = eachAssociation.getId();
				productCategoryService.removeProductCategory(idProductCategoryToBeRemoved);
			}
		}
		
		Long id = category.getId();
		return "redirect:/categories/"+id;
		
	}
	
	// GET Request for deleting a category
	@RequestMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/dashboard";
    }
}
