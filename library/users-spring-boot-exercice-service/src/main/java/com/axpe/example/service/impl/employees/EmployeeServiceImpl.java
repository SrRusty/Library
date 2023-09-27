package com.axpe.example.service.impl.employees;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.axpe.example.persistence.entities.Employee;
import com.axpe.example.persistence.repository.employees.IEmployeeRepository;
import com.axpe.example.service.IEmployeeService;
import com.axpe.example.service.dto.employees.EmployeeDTO;
import com.axpe.example.service.dto.employees.EmployeeIdDTO;
import com.axpe.example.service.exceptions.ContentNotFoundException;
import com.axpe.example.service.exceptions.ErrorCode;
import com.axpe.example.service.mapping.employees.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public Page<EmployeeDTO> getAllEmployees(@PageableDefault(size = 2) Pageable pageable, @RequestParam(required = false) String name, @RequestParam(required = false) String nif, @RequestParam(required = false) String status) {
		Page<Employee> result =  employeeRepository.findUsersWithFilter(employeeRepository, name, nif, status, pageable);
		return result.map(employeeMapper::employeeToEmployeeDTO);
	}
	
	@Override
	public EmployeeDTO getEmployeeByID(@PathVariable Integer id) {
		return employeeMapper.employeeToEmployeeDTO(tryEmployeeExist(id, employeeRepository));
	}
	
	@Override
	public EmployeeDTO newEmployee(@Valid @RequestBody EmployeeIdDTO newEmployee) {
		Employee employee = employeeMapper.employeeIdDTOToEmployee(newEmployee);
		EmployeeDTO userDTO = employeeMapper.employeeToEmployeeDTO(employeeRepository.createEmployee(employee));
		return userDTO;
	}
	 
	@Override
	public void deleteEmployee(@PathVariable Integer id) {
		employeeRepository.deleteEmployee(tryEmployeeExist(id, employeeRepository));
	}
	
	@Override
	public EmployeeDTO editEmployee(@Valid @RequestBody EmployeeIdDTO employeeIdDTO, @PathVariable Integer id) {
		Employee employeBBDD = tryEmployeeExist(id, employeeRepository);
		employeeIdDTO.setId(id);
		Employee employee = employeeMapper.employeeIdDTOToEmployee(employeeIdDTO);
		employee.setEntryDate(employeBBDD.getEntryDate());
		EmployeeDTO userDTO = employeeMapper.employeeToEmployeeDTO(employeeRepository.modifyEmployee(employee));
		return userDTO;
	}
	
	@Override
	public EmployeeDTO patchEmployee(@RequestBody EmployeeIdDTO updateEmployeeIdPart, @PathVariable Integer id) {
		return updateByValues(employeeMapper, employeeRepository, updateEmployeeIdPart, id);
	}
	
	Employee tryEmployeeExist(Integer id, IEmployeeRepository employeeRepository) {
		return employeeRepository.findById(id).orElseThrow(() -> new ContentNotFoundException(ErrorCode.OBJECT_NOT_FOUND));
	}
	
	EmployeeDTO updateByValues(EmployeeMapper employeeMapper, IEmployeeRepository employeeRepository, EmployeeIdDTO updateEmployeeIdPart, Integer id) {
		Employee employee = tryEmployeeExist(id, employeeRepository);;
		
		if (updateEmployeeIdPart.getPassword() != null)
			employee.setPassword(updateEmployeeIdPart.getPassword());
		
		if (updateEmployeeIdPart.getUsername() != null)
			employee.setNickname(updateEmployeeIdPart.getUsername());
		
		if (updateEmployeeIdPart.getFirstName() != null)
			employee.setName(updateEmployeeIdPart.getFirstName());
		
		if (updateEmployeeIdPart.getLastName() != null)
			employee.setSurname1(updateEmployeeIdPart.getLastName());
		
		if (updateEmployeeIdPart.getLastName2() != null)
			employee.setSurname2(updateEmployeeIdPart.getLastName2());
		
		if (updateEmployeeIdPart.getEmail() != null)
			employee.setEmail(updateEmployeeIdPart.getEmail());
		
		if (updateEmployeeIdPart.getPhone() != null)
			employee.setPhoneNumber(updateEmployeeIdPart.getPhone());
		
		if (updateEmployeeIdPart.getNif() != null)
			employee.setNif(updateEmployeeIdPart.getNif());
		
		if (updateEmployeeIdPart.getUserStatus() != null)
			employee.setStatus(updateEmployeeIdPart.getUserStatus());
		
		EmployeeDTO userDTO = employeeMapper.employeeToEmployeeDTO(employeeRepository.modifyEmployee(employee));
		return userDTO;
	
	}

}
