package com.axpe.example.persistence.repository.employees;


import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.axpe.example.persistence.entities.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
    
	public default Page<Employee> findUsersWithFilter(IEmployeeRepository employeeRepository, String name, String nif, String status, Pageable pageable) {
	    EmployeeSpecification spec = new EmployeeSpecification(name, nif, status);
	    return employeeRepository.findAll(spec, pageable);
	}
	
	public default Employee createEmployee(Employee employee) {
		employee.setEntryDate(new Date());
		return save(employee);
	}
	
	public default Employee modifyEmployee(Employee employee) {
		employee.setModifiedDate(new Date());
		return save(employee);
	}
	
	public default Employee deleteEmployee(Employee employee) {
		employee.setStatus("ELIMINADO");
		employee.setCancelDate(new Date());
		return save(employee);
	}
	
}
