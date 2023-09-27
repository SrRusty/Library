package com.axpe.example.service.mapping.books;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.axpe.example.persistence.entities.Book;
import com.axpe.example.service.dto.books.BookDTO;
import com.axpe.example.service.dto.books.BookIdDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
	
	@Mapping(target="idBook", source="book.id")
	@Mapping(target="bookName", source="book.name")
	BookIdDTO bookToBookIdDTO(Book book);
	
	@Mapping(target="bookName", source="book.name")
	BookDTO bookToBookDTO(Book book);
    
	@Mapping(target="id", source="bookIdDTO.idBook")
	@Mapping(target="name", source="bookIdDTO.bookName")
    Book bookIdDTOToBook(BookIdDTO bookIdDTO);
    
	@Mapping(target="name", source="bookIdDTO.bookName")
    Book bookIdDTOToBookWithoutID(BookIdDTO bookIdDTO);
	
}
