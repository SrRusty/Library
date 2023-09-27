package com.axpe.example.service.mapping.employees;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.axpe.example.persistence.entities.Employee;
import com.axpe.example.service.dto.employees.EmployeeDTO;
import com.axpe.example.service.dto.employees.EmployeeIdDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {
	
	@Mapping(target="username", source="employee.nickname")
	@Mapping(target="firstName", source="employee.name")
	@Mapping(target="lastName", source="employee.surname1")
	@Mapping(target="lastName2", source="employee.surname2")
	@Mapping(target="phone", source="employee.phoneNumber")
	@Mapping(target="userStatus", source="employee.status")
	EmployeeIdDTO employeeToEmployeeIdDTO(Employee employee);
	
	@Mapping(target="username", source="employee.nickname")
	@Mapping(target="firstName", source="employee.name")
	@Mapping(target="lastName", source="employee.surname1")
	@Mapping(target="lastName2", source="employee.surname2")
	@Mapping(target="phone", source="employee.phoneNumber")
	@Mapping(target="userStatus", source="employee.status")
	EmployeeDTO employeeToEmployeeDTO(Employee employee);
    
	@Mapping(target="nickname", source="employeeIdDTO.username")
	@Mapping(target="name", source="employeeIdDTO.firstName")
	@Mapping(target="surname1", source="employeeIdDTO.lastName")
	@Mapping(target="surname2", source="employeeIdDTO.lastName2")
	@Mapping(target="phoneNumber", source="employeeIdDTO.phone")
	@Mapping(target="status", source="employeeIdDTO.userStatus")
    Employee employeeIdDTOToEmployee(EmployeeIdDTO employeeIdDTO);
    
	@Mapping(target="nickname", source="employeeIdDTO.username")
	@Mapping(target="name", source="employeeIdDTO.firstName")
	@Mapping(target="surname1", source="employeeIdDTO.lastName")
	@Mapping(target="surname2", source="employeeIdDTO.lastName2")
	@Mapping(target="phoneNumber", source="employeeIdDTO.phone")
	@Mapping(target="status", source="employeeIdDTO.userStatus")
    Employee employeeIdDTOToEmployeeWithoutID(EmployeeIdDTO employeeIdDTO);
	
}
