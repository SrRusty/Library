package com.axpe.example.service;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.axpe.example.service.dto.employees.EmployeeDTO;
import com.axpe.example.service.dto.employees.EmployeeIdDTO;

	

public interface IEmployeeService {

	public Page<EmployeeDTO> getAllEmployees(@PageableDefault(size = 2) Pageable pageable, @RequestParam(required = false) String name, @RequestParam(required = false) String nif, @RequestParam(required = false) String status);
	
	public EmployeeDTO getEmployeeByID(@PathVariable Integer id);
	
	public EmployeeDTO newEmployee(@Valid @RequestBody EmployeeIdDTO newEmployee);
	
	public void deleteEmployee(@PathVariable Integer id);
	
	public EmployeeDTO editEmployee(@Valid @RequestBody EmployeeIdDTO employeeIdDTO, @PathVariable Integer id);
	
	public EmployeeDTO patchEmployee(@RequestBody EmployeeIdDTO updateEmployeeIdPart, @PathVariable Integer id);
	
}
