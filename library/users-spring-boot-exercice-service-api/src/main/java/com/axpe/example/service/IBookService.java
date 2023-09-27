package com.axpe.example.service;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.axpe.example.service.dto.books.BookDTO;
import com.axpe.example.service.dto.books.BookIdDTO;

	

public interface IBookService {

	public Page<BookDTO> getAllBooks(@PageableDefault(size = 2) Pageable pageable, @RequestParam(required = false) String name, @RequestParam(required = false) String author, @RequestParam(required = false) String status);
	
	public BookDTO getBookByID(@PathVariable Integer id);
	
	public BookDTO newBook(@Valid @RequestBody BookIdDTO newBook);
	
	public void deleteBook(@PathVariable Integer id);
	
	public BookDTO editBook(@Valid @RequestBody BookIdDTO bookIdDTO, @PathVariable Integer id);
	
	public BookDTO patchBook(@RequestBody BookIdDTO updateBookIdPart, @PathVariable Integer id);
	
}
