package com.axpe.example.service.dto.employees;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class EmployeeDTO {

	private String username;
	
	private String firstName;
	
	private String lastName;
	
	private String lastName2;
	
	@NotBlank
	private String email;
	
	@Pattern(regexp = "\\+[0-9]{1,3}-[0-9()+\\-]{1,30}",
			message = "Error en la expresión del telefono")
	private String phone;
	
	private String nif;

	@Pattern(regexp = "ACTIVO|PENDIENTE|DESACTIVADO",
			message = "Error en la expresión del estado del usuario")
    private String userStatus;
	
}