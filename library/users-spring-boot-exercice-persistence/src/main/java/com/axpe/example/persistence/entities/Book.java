package com.axpe.example.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "books")
@Builder
public class Book {
	
	@Id @GeneratedValue(generator = "sq_books") @Column(name = "idBooks")
	private Integer id;
	
	private String name;
	
	private String description;
	
	private String author;
	
	private String category;
	
	@Column(name = "entry_date")
	private Date entryDate;
	
	@Column(name = "cancel_date")
	private Date cancelDate;
	
	@Column(name = "modified_date")
	private Date modifiedDate;
	
}
