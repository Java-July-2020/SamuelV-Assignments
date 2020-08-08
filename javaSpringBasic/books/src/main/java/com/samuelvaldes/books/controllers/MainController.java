package com.samuelvaldes.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.samuelvaldes.books.models.Book;
import com.samuelvaldes.books.services.BookService;

@Controller
public class MainController {
	
	// I) Attributes and Constructor for Controller
	
	private final BookService bookService;
	
	public MainController (BookService bookService) {
		this.bookService = bookService;
	}
	
	
	// II) Show all books method
	
	@RequestMapping("/books")
	public String showAllbooks(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "books.jsp";
	}
	
	// III) Find a Specific book method
	
	@RequestMapping("/books/{index}")
	public String findBook(Model model, @PathVariable("index") Long id) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "showBook.jsp";
	}
	
	// IV) Create new book methods (two methods, one with a GET and other with POST request)
	
	// GET Request
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "newBook.jsp";
	}
	
	// POST Request
	@RequestMapping(value="/books/new", method=RequestMethod.POST)
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		}
		else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	// V) Update a book methods (two methods, one with a GET and other with POST request)
	
	// GET Request
	@RequestMapping("/books/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model ) {
		Book book = bookService.findBook(id);
		System.out.println("GET Request");
		if (book != null) {
			model.addAttribute("book",book);
			return "editBook.jsp";
		}
		else {
			return "redirect:/books";
		}
	}
	
	// POST Request
	@RequestMapping(value="/books/edit/{id}", method=RequestMethod.POST)
	public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		
		if (result.hasErrors()) {
			return "editBook.jsp";
		}
		else {
			bookService.updateBook(book);
			return "redirect:/books";
		}
		
	}
	
	// V) Delete a book methods
	
	
	// GET Request
	@RequestMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
	
	
	
	
}
