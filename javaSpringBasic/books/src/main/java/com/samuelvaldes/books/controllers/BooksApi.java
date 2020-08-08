package com.samuelvaldes.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samuelvaldes.books.models.Book;
import com.samuelvaldes.books.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;
    public BooksApi (BookService bookService){
        this.bookService = bookService;
    }
    
    // Show All books
    @RequestMapping("/api/books")
    public List<Book> index() {
        return this.bookService.allBooks();
    }
    
    
    // Create book
    @RequestMapping(value="/api/books/new", method=RequestMethod.POST)
    public Book create(
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
    	
        Book book = new Book(title, desc, lang, numOfPages);
        return this.bookService.createBook(book);
    }
    
    // Get book
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
    
    // Update book
    
    @RequestMapping(value="/api/books/update/{id}", method=RequestMethod.PUT)
    public Book update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }
    
    // Delete book
    
    @RequestMapping(value="/api/books/delete/{id}", method=RequestMethod.DELETE)
    public void remove(@PathVariable("id") Long id) {
        this.bookService.deleteBook(id);
    }
}
