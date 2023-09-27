package com.axpe.example.service.impl.books;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.axpe.example.persistence.entities.Book;
import com.axpe.example.persistence.repository.books.IBookRepository;
import com.axpe.example.service.IBookService;
import com.axpe.example.service.dto.books.BookDTO;
import com.axpe.example.service.dto.books.BookIdDTO;
import com.axpe.example.service.exceptions.ContentNotFoundException;
import com.axpe.example.service.exceptions.ErrorCode;
import com.axpe.example.service.mapping.books.BookMapper;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookRepository bookRepository;
	@Autowired
	private BookMapper bookMapper;

	@Override
	public Page<BookDTO> getAllBooks(@PageableDefault(size = 2) Pageable pageable, @RequestParam(required = false) String name, @RequestParam(required = false) String author, @RequestParam(required = false) String category) {
		Page<Book> result =  bookRepository.findUsersWithFilter(bookRepository, name, author, category, pageable);
		return result.map(bookMapper::bookToBookDTO);
	}
	
	@Override
	public BookDTO getBookByID(@PathVariable Integer id) {
		return bookMapper.bookToBookDTO(tryBookExist(id, bookRepository));
	}
	
	@Override
	public BookDTO newBook(@Valid @RequestBody BookIdDTO newBook) {
		Book book = bookMapper.bookIdDTOToBook(newBook);
		BookDTO userDTO = bookMapper.bookToBookDTO(bookRepository.createBook(book));
		return userDTO;
	}
	 
	@Override
	public void deleteBook(@PathVariable Integer id) {
		bookRepository.deleteBook(tryBookExist(id, bookRepository));
	}
	
	@Override
	public BookDTO editBook(@Valid @RequestBody BookIdDTO bookIdDTO, @PathVariable Integer id) {
		Book employeBBDD = tryBookExist(id, bookRepository);
		bookIdDTO.setIdBook(id);
		Book book = bookMapper.bookIdDTOToBook(bookIdDTO);
		book.setEntryDate(employeBBDD.getEntryDate());
		BookDTO userDTO = bookMapper.bookToBookDTO(bookRepository.modifyBook(book));
		return userDTO;
	}
	
	@Override
	public BookDTO patchBook(@RequestBody BookIdDTO updateBookIdPart, @PathVariable Integer id) {
		return updateByValues(bookMapper, bookRepository, updateBookIdPart, id);
	}
	
	Book tryBookExist(Integer id, IBookRepository bookRepository) {
		return bookRepository.findById(id).orElseThrow(() -> new ContentNotFoundException(ErrorCode.OBJECT_NOT_FOUND));
	}
	
	BookDTO updateByValues(BookMapper bookMapper, IBookRepository bookRepository, BookIdDTO updateBookIdPart, Integer id) {
		Book book = tryBookExist(id, bookRepository);;
		
		if (updateBookIdPart.getBookName() != null)
			book.setName(updateBookIdPart.getBookName());
		
		if (updateBookIdPart.getDescription() != null)
			book.setDescription(updateBookIdPart.getDescription());
		
		if (updateBookIdPart.getAuthor() != null)
			book.setAuthor(updateBookIdPart.getAuthor());
		
		if (updateBookIdPart.getCategory() != null)
			book.setCategory(updateBookIdPart.getCategory());
		
		BookDTO userDTO = bookMapper.bookToBookDTO(bookRepository.modifyBook(book));
		return userDTO;
	
	}

}
