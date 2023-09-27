package com.axpe.example.persistence.repository.books;


import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.axpe.example.persistence.entities.Book;

public interface IBookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {
    
	public default Page<Book> findUsersWithFilter(IBookRepository bookRepository, String name, String author, String category, Pageable pageable) {
	    BookSpecification spec = new BookSpecification(name, author, category);
	    return bookRepository.findAll(spec, pageable);
	}
	
	public default Book createBook(Book book) {
		book.setEntryDate(new Date());
		return save(book);
	}
	
	public default Book modifyBook(Book book) {
		book.setModifiedDate(new Date());
		return save(book);
	}
	
	public default Book deleteBook(Book book) {
		book.setCancelDate(new Date());
		return save(book);
	}
	
}
