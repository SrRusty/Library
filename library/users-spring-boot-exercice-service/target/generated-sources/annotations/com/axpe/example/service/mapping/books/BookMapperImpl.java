package com.axpe.example.service.mapping.books;

import com.axpe.example.persistence.entities.Book;
import com.axpe.example.service.dto.books.BookDTO;
import com.axpe.example.service.dto.books.BookIdDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-27T10:17:07+0200",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookIdDTO bookToBookIdDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookIdDTO.BookIdDTOBuilder bookIdDTO = BookIdDTO.builder();

        bookIdDTO.idBook( book.getId() );
        bookIdDTO.bookName( book.getName() );
        bookIdDTO.author( book.getAuthor() );
        bookIdDTO.category( book.getCategory() );
        bookIdDTO.description( book.getDescription() );

        return bookIdDTO.build();
    }

    @Override
    public BookDTO bookToBookDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO.BookDTOBuilder bookDTO = BookDTO.builder();

        bookDTO.bookName( book.getName() );
        bookDTO.author( book.getAuthor() );
        bookDTO.category( book.getCategory() );
        bookDTO.description( book.getDescription() );

        return bookDTO.build();
    }

    @Override
    public Book bookIdDTOToBook(BookIdDTO bookIdDTO) {
        if ( bookIdDTO == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        book.id( bookIdDTO.getIdBook() );
        book.name( bookIdDTO.getBookName() );
        book.author( bookIdDTO.getAuthor() );
        book.category( bookIdDTO.getCategory() );
        book.description( bookIdDTO.getDescription() );

        return book.build();
    }

    @Override
    public Book bookIdDTOToBookWithoutID(BookIdDTO bookIdDTO) {
        if ( bookIdDTO == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        book.name( bookIdDTO.getBookName() );
        book.author( bookIdDTO.getAuthor() );
        book.category( bookIdDTO.getCategory() );
        book.description( bookIdDTO.getDescription() );

        return book.build();
    }
}
