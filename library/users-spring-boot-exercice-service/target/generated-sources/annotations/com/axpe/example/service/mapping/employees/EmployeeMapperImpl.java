package com.axpe.example.service.mapping.employees;

import com.axpe.example.persistence.entities.Employee;
import com.axpe.example.service.dto.employees.EmployeeDTO;
import com.axpe.example.service.dto.employees.EmployeeIdDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-27T10:17:07+0200",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeIdDTO employeeToEmployeeIdDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeIdDTO.EmployeeIdDTOBuilder employeeIdDTO = EmployeeIdDTO.builder();

        employeeIdDTO.username( employee.getNickname() );
        employeeIdDTO.firstName( employee.getName() );
        employeeIdDTO.lastName( employee.getSurname1() );
        employeeIdDTO.lastName2( employee.getSurname2() );
        employeeIdDTO.phone( employee.getPhoneNumber() );
        employeeIdDTO.userStatus( employee.getStatus() );
        employeeIdDTO.email( employee.getEmail() );
        employeeIdDTO.id( employee.getId() );
        employeeIdDTO.nif( employee.getNif() );
        employeeIdDTO.password( employee.getPassword() );

        return employeeIdDTO.build();
    }

    @Override
    public EmployeeDTO employeeToEmployeeDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO.EmployeeDTOBuilder employeeDTO = EmployeeDTO.builder();

        employeeDTO.username( employee.getNickname() );
        employeeDTO.firstName( employee.getName() );
        employeeDTO.lastName( employee.getSurname1() );
        employeeDTO.lastName2( employee.getSurname2() );
        employeeDTO.phone( employee.getPhoneNumber() );
        employeeDTO.userStatus( employee.getStatus() );
        employeeDTO.email( employee.getEmail() );
        employeeDTO.nif( employee.getNif() );

        return employeeDTO.build();
    }

    @Override
    public Employee employeeIdDTOToEmployee(EmployeeIdDTO employeeIdDTO) {
        if ( employeeIdDTO == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.nickname( employeeIdDTO.getUsername() );
        employee.name( employeeIdDTO.getFirstName() );
        employee.surname1( employeeIdDTO.getLastName() );
        employee.surname2( employeeIdDTO.getLastName2() );
        employee.phoneNumber( employeeIdDTO.getPhone() );
        employee.status( employeeIdDTO.getUserStatus() );
        employee.email( employeeIdDTO.getEmail() );
        employee.id( employeeIdDTO.getId() );
        employee.nif( employeeIdDTO.getNif() );
        employee.password( employeeIdDTO.getPassword() );

        return employee.build();
    }

    @Override
    public Employee employeeIdDTOToEmployeeWithoutID(EmployeeIdDTO employeeIdDTO) {
        if ( employeeIdDTO == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.nickname( employeeIdDTO.getUsername() );
        employee.name( employeeIdDTO.getFirstName() );
        employee.surname1( employeeIdDTO.getLastName() );
        employee.surname2( employeeIdDTO.getLastName2() );
        employee.phoneNumber( employeeIdDTO.getPhone() );
        employee.status( employeeIdDTO.getUserStatus() );
        employee.email( employeeIdDTO.getEmail() );
        employee.id( employeeIdDTO.getId() );
        employee.nif( employeeIdDTO.getNif() );
        employee.password( employeeIdDTO.getPassword() );

        return employee.build();
    }
}
