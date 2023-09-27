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
@Table(name = "users")
@Builder
public class Employee {
	
	@Id @GeneratedValue(generator = "sq_users")
	private Integer id;
	
	private String name;
	
	private String surname1;
	
	private String surname2;
	
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	private String nif;
	
	private String nickname; 
	
	private String password;
	
    private String status;
	
	@Column(name = "entry_date")
	private Date entryDate;
	
	@Column(name = "cancel_date")
	private Date cancelDate;
	
	@Column(name = "modified_date")
	private Date modifiedDate;
	
}
