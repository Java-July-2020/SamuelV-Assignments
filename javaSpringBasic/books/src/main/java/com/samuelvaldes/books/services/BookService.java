package com.samuelvaldes.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.samuelvaldes.books.models.Book;
import com.samuelvaldes.books.repositories.BookRepository;

@Service
public class BookService {
	
	// adding the book repository as a dependency
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// return all the books
	public List<Book> allBooks(){
		return this.bookRepository.findAll();
	}
	
	// creates a book
	public Book createBook(Book book) {
		return this.bookRepository.save(book);
	}
	
	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}
	
	// delete book
	public void deleteBook(Long id) {
		this.bookRepository.deleteById(id);
	}
	
	//updateBook
	public Book updateBook(Long id, Book updatedBook) {
		return this.bookRepository.save(updatedBook);
	}

}
