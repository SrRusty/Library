package com.axpe.example.service.impl;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.axpe.example.persistence.repository.employees.IEmployeeRepository;
import com.axpe.example.service.IEmployeeService;
import com.axpe.example.service.impl.employees.EmployeeServiceImpl;
import com.axpe.example.service.mapping.employees.EmployeeMapper;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@Mock
	private IEmployeeRepository employeeRepository;
	
	@Mock
	private EmployeeMapper employeeMapper;
	
	@Mock
	private IEmployeeService employeeService;
	
	@Mock
	private EmployeeServiceImpl employeeServiceImpl;

//	@Test
//	void developThings() {
//		// given
//		final Integer id = 1;
//		final String name = "Kevin";
//		final Employee employee = Employee.builder().id(id).name(name).build();
//		final EmployeeDTO employeeDTO = EmployeeDTO.builder().firstName(name).build();
//		final EmployeeDTO employeeDTO1 = EmployeeDTO.builder().firstName("Paco").userStatus("ACTIVO").build();
//		final EmployeeDTO employeeDTO2 = EmployeeDTO.builder().firstName("Kevin").userStatus("ACTIVO").build();
//		final EmployeeDTO employeeDTO3 = EmployeeDTO.builder().firstName("Jesus").userStatus("ACTIVO").build();
//		final EmployeeDTO employeeDTO4 = EmployeeDTO.builder().firstName("Maria").userStatus("ACTIVO").build();
//		ArrayList<EmployeeDTO> listEmployee = new ArrayList<>();
//		listEmployee.add(employeeDTO1);
//		listEmployee.add(employeeDTO2);
//		listEmployee.add(employeeDTO3);
//		listEmployee.add(employeeDTO4);
//		List<Employee> listEmployee2 = new ArrayList<>();
//		listEmployee2.add(employee);
//		
////		final Page<EmployeeDTO> employeePage = new PageImpl<>(listEmployee);
//
//		when(this.employeeRepository.findById(id)).thenReturn(Optional.of(employee));
//		when(this.employeeRepository.findAll()).thenReturn(listEmployee2);
//		when(this.mapperEmployeeDTOImpl.employeeToEmployeeDTO(employee)).thenReturn(employeeDTO);
//
//		// when
//		EmployeeDTO retrievedEmployeeDTO = (EmployeeDTO) this.service.getEmployeeByID(id).getBody();
//		Employee employeeRetrieved = employeeRepository.findById(id).get();
//		List<Employee> listEmployee3 = employeeRepository.findAll();
//		
//		// then
//		verify(this.employeeRepository, times(2)).findById(id);
//		verify(this.mapperEmployeeDTOImpl, times(1)).employeeToEmployeeDTO(employee);
//		verify(this.employeeRepository, times(1)).findAll();
//
//		Assertions.assertEquals(retrievedEmployeeDTO.getFirstName(), name);
//		Assertions.assertEquals(employeeRetrieved.getId(), id);
//		Assertions.assertEquals(listEmployee3.size(), 1);
//
//		}
	
//	@Test
//	void getEmployeeByID_when_exists_returnData() {
//		// given
//		final Integer id = 1;
//		final String name = "Kevin";
//		final Employee employee = Employee.builder().id(id).name(name).build();
//		final EmployeeDTO employeeDTO = EmployeeDTO.builder().firstName(name).build();
//
//		when(this.employeeRepository.findById(id)).thenReturn(Optional.of(employee));
//		when(this.employeeMapper.employeeToEmployeeDTO(employee)).thenReturn(employeeDTO);
//
//		// when
//		Employee employeeRetrieved = employeeRepository.findById(id).get();
//		EmployeeDTO retrievedEmployeeDTO = employeeMapper.employeeToEmployeeDTO(employee);
//		
//		// then
//		verify(this.employeeRepository, times(1)).findById(id);
//		verify(this.employeeMapper, times(1)).employeeToEmployeeDTO(employee);
//
//		Assertions.assertEquals(retrievedEmployeeDTO.getFirstName(), name);
//		Assertions.assertEquals(employeeRetrieved.getId(), id);
//
//		}
//	
//	@Test
//	void getAllEmployees_when_exists_returnData() {
//		// given
//		final Integer id = 1;
//		final String name = "Kevin";
//		final Employee employee = Employee.builder().id(id).name(name).build();
//		List<Employee> listEmployee2 = new ArrayList<>();
//		listEmployee2.add(employee);
//		
//		final EmployeeSpecification spec = new EmployeeSpecification(employee.getName(), employee.getNif(), employee.getStatus());
//		final Page<Employee> employeePage = new PageImpl<>(listEmployee2);
//
//		when(this.employeeRepository.findAll()).thenReturn(listEmployee2);
//		when(this.employeeRepository.findAll(spec, employeePage.getPageable())).thenReturn(employeePage);
//
//		// when
//		List<Employee> listEmployee3 = employeeRepository.findAll();
//		Page<Employee> retrievedEmployeePage = employeeRepository.findAll(spec, employeePage.getPageable());
//		
//		// then
//		verify(this.employeeRepository, times(1)).findAll(spec, employeePage.getPageable());
//
//		Assertions.assertTrue(listEmployee3.size() > 0, "getAll no ha recuperado datos");
//		Assertions.assertTrue(retrievedEmployeePage.getNumberOfElements() > 0, "getAll-Pageable no ha recuperado datos");
//
//		}
//	
//	@Test
//	void deleteEmployee_when_exists_returnData() {
//		// given
//		final Integer id = 1;
//		final String name = "Kevin";
//		final Employee employee = Employee.builder().id(id).name(name).build();
//
//		when(this.employeeRepository.findById(id)).thenReturn(Optional.of(employee));
//
//		// when
//		Employee employeeRetrieved = employeeRepository.findById(id).get();
//		employeeRepository.delete(employee);
//		
//		// then
//		verify(this.employeeRepository, times(1)).findById(id);
//		verify(this.employeeRepository, times(1)).delete(employeeRetrieved);
//
//		Assertions.assertEquals(employeeRetrieved.getId(), id);
//
//		}
//	
//	@Test
//	void newEmployee_when_exists_returnData() {
//		// given
//		final String name = "Kevin";
//		final String userName = "KevinMG";
//		final String password = "Kevin1245";
//		final EmployeeIdDTO employeeIdDTO = EmployeeIdDTO.builder().firstName(name).username(userName).password(password).build();
//		final Employee employee = Employee.builder().id(1).name(name).nickname(userName).password(password).build();
//
//		when(this.employeeMapper.employeeIdDTOToEmployee(employeeIdDTO)).thenReturn(employee);
//		when(this.employeeRepository.save(employee)).thenReturn(employee);
//		
//		// when
//		Employee employeeRetrieved = employeeMapper.employeeIdDTOToEmployee(employeeIdDTO);
//		Employee employeeSave = employeeRepository.save(employeeRetrieved);
//		
//		// then
//		verify(this.employeeMapper, times(1)).employeeIdDTOToEmployee(employeeIdDTO);
//		verify(this.employeeRepository, times(1)).save(employee);
//
//		Assertions.assertEquals(employeeRetrieved.getName(), name);
//		Assertions.assertEquals(employeeRetrieved.getNickname(), userName);
//		Assertions.assertEquals(employeeSave.getId(), 1);
//
//		}
//
//	
//	@Test
//	void editEmployeeByID_when_exists_returnData() {
//		// given
//		final Date date = new Date();
//		final Integer id = 1;
//		final String name = "Kevin";
//		final Employee employee = Employee.builder().id(id).name(name).entryDate(date).build();
//		final EmployeeIdDTO employeeIdDTO = EmployeeIdDTO.builder().id(id).firstName(name).build();
//		final EmployeeDTO employeeDTO = EmployeeDTO.builder().firstName(name).build();
//
//		when(this.employeeMapper.employeeIdDTOToEmployee(employeeIdDTO)).thenReturn(employee);
//		when(this.employeeMapper.employeeToEmployeeDTO(this.employeeRepository.save(employee))).thenReturn(employeeDTO);
//
//		// when
//		Employee employeeRetrieved = employeeMapper.employeeIdDTOToEmployee(employeeIdDTO);
//		EmployeeDTO employeeDTORetrieved = employeeMapper.employeeToEmployeeDTO(employeeRepository.save(employeeRetrieved));
//		
//		// then
//		verify(this.employeeRepository, times(2)).save(employee);
//
//		Assertions.assertEquals(employeeDTORetrieved.getFirstName(), name);
//		Assertions.assertEquals(employeeRetrieved.getEntryDate(), date);
//
//		}
//	
//	@Test
//	void patchEmployeeByID_when_exists_returnData() {
//		// given
//		final Integer id = 1;
//		final String name = "Kevin";
//		final EmployeeIdDTO employeeIdDTO = EmployeeIdDTO.builder().id(id).firstName(name).build();
//		final EmployeeDTO employeeDTO = EmployeeDTO.builder().firstName(name).build();
//
//		when(employeeServiceImpl.updateByValues(employeeMapper, employeeRepository, employeeIdDTO, id)).thenReturn(employeeDTO);
//
//		// when
//		EmployeeDTO employeeDTORetrieved = employeeServiceImpl.updateByValues(employeeMapper, employeeRepository, employeeIdDTO, id);
//		
//		// then
//		verify(this.employeeServiceImpl, times(1)).updateByValues(employeeMapper, employeeRepository, employeeIdDTO, id);
//
//		Assertions.assertEquals(employeeDTORetrieved.getFirstName(), name);
//
//		}
//	
//	@Test
//	void getEmployeeByID_when_not_exists_returnData() {
//		// given
//		final Integer id = 1;
//		final ContentNotFoundException exception = new ContentNotFoundException(ErrorCode.OBJECT_NOT_FOUND);
//		
//		when(this.employeeServiceImpl.tryEmployeeExist(12, employeeRepository)).thenThrow(exception);
//		
//		// when 
//		ContentNotFoundException exceptionRetireved = Assertions.assertThrows(ContentNotFoundException.class,
//				() -> {employeeServiceImpl.tryEmployeeExist(12, employeeRepository); });
//		
//		verify(this.employeeRepository, times(0)).findById(id);
////
//		Assertions.assertEquals(exceptionRetireved.getErrorCode(), ErrorCode.OBJECT_NOT_FOUND);
//
//		}
	
}
