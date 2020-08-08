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
		for (Book book : this.bookRepository.findAll()) {
			System.out.println(book.getId() + " " + book.getTitle());
		}
		return this.bookRepository.findAll();
	}
	
	// creates a book
	public Book createBook(Book book) {
		return this.bookRepository.save(book);
	}
	
	// retrieves a book
	public Book findBook(Long id) {
		Book book = this.bookRepository.findById(id).orElse(null);
		return book;
	}
	
	// delete book
	public void deleteBook(Long id) {
		this.bookRepository.deleteById(id);
	}
	
	// update Book
	public Book updateBook(Book updatedBook) {
		return this.bookRepository.save(updatedBook);
    }
	
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book updatedBook = this.bookRepository.findById(id).orElse(null);
		
		if (updatedBook != null) {
			updatedBook.setTitle(title);
			updatedBook.setDescription(desc);
			updatedBook.setLanguage(lang);
			updatedBook.setNumberOfPages(numOfPages);
		}
		return this.bookRepository.save(updatedBook);
    }
	
}
