package com.axpe.example.presentation.controllers.books;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.axpe.example.service.dto.books.BookDTO;
import com.axpe.example.service.dto.books.BookIdDTO;

public interface IBookControler {

	@GetMapping("/books")
	public ResponseEntity<Page<BookDTO>> getAllBooks(@PageableDefault(size = 10) Pageable pageable, @RequestParam(required = false) String name, @RequestParam(required = false) String author, @RequestParam(required = false) String category);
	
	@GetMapping("/books/{id}")
	public ResponseEntity<BookDTO> getBookByID(@PathVariable Integer id);
	
	@PostMapping("/books")
	public ResponseEntity<BookDTO> newBook(@Valid @RequestBody BookIdDTO newBook);
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Integer id);
	
	@PutMapping("/books/{id}")
	public ResponseEntity<BookDTO> editBook(@Valid @RequestBody BookIdDTO employeeIdDTO, @PathVariable Integer id);
	
	@PatchMapping("/books/{id}")
	public ResponseEntity<BookDTO> patchBook(@RequestBody BookIdDTO updateBookIdPart, @PathVariable Integer id);
	
}

