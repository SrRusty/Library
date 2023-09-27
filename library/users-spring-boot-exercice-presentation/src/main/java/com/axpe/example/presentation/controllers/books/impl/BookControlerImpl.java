package com.axpe.example.presentation.controllers.books.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axpe.example.presentation.controllers.books.IBookControler;
import com.axpe.example.service.IBookService;
import com.axpe.example.service.dto.books.BookDTO;
import com.axpe.example.service.dto.books.BookIdDTO;

@RestController
public class BookControlerImpl implements IBookControler{

	@Autowired
	private IBookService bookService;
	
	public ResponseEntity<Page<BookDTO>> getAllBooks(@PageableDefault(size = 10) Pageable pageable, @RequestParam(required = false) String name, @RequestParam(required = false) String author, @RequestParam(required = false) String category){
		Page<BookDTO> pagableOut = bookService.getAllBooks(pageable, name, author, category);
		if (pagableOut.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(pagableOut);
	}
	
	public ResponseEntity<BookDTO> getBookByID(@PathVariable Integer id) {
		return ResponseEntity.ok(bookService.getBookByID(id));
	}
	
	public ResponseEntity<BookDTO> newBook(@Valid @RequestBody BookIdDTO newBook) {
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.newBook(newBook));
	}
	
	public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
		bookService.deleteBook(id);
		return ResponseEntity.noContent().build();
	}
	
	public ResponseEntity<BookDTO> editBook(@Valid @RequestBody BookIdDTO bookIdDTO, @PathVariable Integer id) {
		return ResponseEntity.ok(bookService.editBook(bookIdDTO, id));
	}
	
	public ResponseEntity<BookDTO> patchBook(@RequestBody BookIdDTO updateBookIdPart, @PathVariable Integer id) {
		return ResponseEntity.ok(bookService.patchBook(updateBookIdPart, id));
	}

}

