package com.axpe.example.presentation.controllers.employees;

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

import com.axpe.example.service.dto.employees.EmployeeDTO;
import com.axpe.example.service.dto.employees.EmployeeIdDTO;

public interface IEmployeeControler {

	@GetMapping("/employees")
	public ResponseEntity<Page<EmployeeDTO>> getAllEmployees(@PageableDefault(size = 10) Pageable pageable, @RequestParam(required = false) String name, @RequestParam(required = false) String nif, @RequestParam(required = false) String status);
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeByID(@PathVariable Integer id);
	
	@PostMapping("/employees")
	public ResponseEntity<EmployeeDTO> newEmployee(@Valid @RequestBody EmployeeIdDTO newEmployee);
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id);
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeDTO> editEmployee(@Valid @RequestBody EmployeeIdDTO employeeIdDTO, @PathVariable Integer id);
	
	@PatchMapping("/employees/{id}")
	public ResponseEntity<EmployeeDTO> patchEmployee(@RequestBody EmployeeIdDTO updateEmployeeIdPart, @PathVariable Integer id);
	
	@GetMapping("/emailVerify/{email}")
	public ResponseEntity<String> getEmailVerify(@PathVariable String email);
}

