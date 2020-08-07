package com.samuelvaldes.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.samuelvaldes.books.models.Book;
import com.samuelvaldes.books.services.BookService;

@Controller
public class MainController {
	private final BookService bookService;
	
	public MainController (BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/books")
	public String showAllbooks(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "books.jsp";
	}
	
	@RequestMapping("/books/{index}")
	public String findBook(Model model, @PathVariable("index") Long index) {
		Book book = bookService.findBook(index);
		model.addAttribute("book", book);
		return "showBook.jsp";
	}
	
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "newBook.jsp";
	}
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		}
		else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	
	
	
}
