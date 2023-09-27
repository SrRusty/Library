package com.axpe.example.presentation.controllers.employees.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.axpe.example.presentation.controllers.employees.IEmployeeControler;
import com.axpe.example.service.IEmployeeService;
import com.axpe.example.service.dto.employees.EmployeeDTO;
import com.axpe.example.service.dto.employees.EmployeeIdDTO;

@RestController
public class EmployeeControlerImpl implements IEmployeeControler{

	@Autowired
	private IEmployeeService employeeService;
	
	public ResponseEntity<Page<EmployeeDTO>> getAllEmployees(@PageableDefault(size = 10) Pageable pageable, @RequestParam(required = false) String name, @RequestParam(required = false) String nif, @RequestParam(required = false) String status){
		Page<EmployeeDTO> pagableOut = employeeService.getAllEmployees(pageable, name, nif, status);
		if (pagableOut.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(pagableOut);
	}
	
	public ResponseEntity<EmployeeDTO> getEmployeeByID(@PathVariable Integer id) {
		return ResponseEntity.ok(employeeService.getEmployeeByID(id));
	}
	
	public ResponseEntity<EmployeeDTO> newEmployee(@Valid @RequestBody EmployeeIdDTO newEmployee) {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.newEmployee(newEmployee));
	}
	
	public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
	
	public ResponseEntity<EmployeeDTO> editEmployee(@Valid @RequestBody EmployeeIdDTO employeeIdDTO, @PathVariable Integer id) {
		return ResponseEntity.ok(employeeService.editEmployee(employeeIdDTO, id));
	}
	
	public ResponseEntity<EmployeeDTO> patchEmployee(@RequestBody EmployeeIdDTO updateEmployeeIdPart, @PathVariable Integer id) {
		return ResponseEntity.ok(employeeService.patchEmployee(updateEmployeeIdPart, id));
	}

	private static final String SECRET = "ts_4c09b6d1-fbcc-482e-95a7-888b5c43c3ce";
	private static final String KEY = "ta_ae047da3eedc99b776e403e067f7db085ecd2";
	private static final String X_TOMBA_SECRET = "X-Tomba-Secret";
	private static final String X_TOMBA_KEY = "X-Tomba-Key";
	private static final String URL = "https://api.tomba.io/v1/email-verifier/{email}";
	
	public ResponseEntity<String> getEmailVerify(@PathVariable String email) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(X_TOMBA_KEY, KEY);
		httpHeaders.add(X_TOMBA_SECRET, SECRET);
		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
		return restTemplate.exchange(URL, HttpMethod.GET, httpEntity, String.class, email);
	}
	
}

