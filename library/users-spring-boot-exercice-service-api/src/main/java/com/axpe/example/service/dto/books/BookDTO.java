package com.axpe.example.service.dto.books;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class BookDTO {

	@NotBlank
	private String bookName;
	
	private String description;
	
	private String author;
	
	private String category;
	
}