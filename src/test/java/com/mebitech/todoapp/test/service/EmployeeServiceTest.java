package com.mebitech.todoapp.test.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mebitech.todoapp.domain.Employee;
import com.mebitech.todoapp.repository.EmployeeRepository;
import com.mebitech.todoapp.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository repository;

	@InjectMocks
	@Autowired
	private EmployeeService service;

	@Test
	public void testAddNewEmployee() throws Exception {
		Employee employee = getEmployee();
		when(repository.findOne(employee.getId())).thenReturn(null);
		when(repository.save(employee)).thenReturn(employee);
		Employee gettingEmployee = service.saveOrUpdate(employee).orElse(new Employee());

		assertThat(gettingEmployee.getId(), is(equalTo(employee.getId())));
	}
	
	@Test	
	public void testRemoveEmployee() throws Exception{
		Employee employee = getEmployee();
		
		when(repository.findOne(employee.getId())).thenReturn(null);
		when(repository.save(employee)).thenReturn(employee);

		Employee gettingEmployee = service.saveOrUpdate(employee).orElse(new Employee());
		gettingEmployee.setRecordIsDeleted(true);
		gettingEmployee.setRecordUpdateTime(new Date());
		service.saveOrUpdate(gettingEmployee);
		
		Employee removedEmployee = service.get(gettingEmployee.getId());

		assertThat(removedEmployee, nullValue());
		
	}
	
	@Test	
	public void testUpdateEmployee() throws Exception{
		Employee employee = getEmployee();
		
		when(repository.findOne(employee.getId())).thenReturn(null);
		when(repository.save(employee)).thenReturn(employee);

		Employee gettingEmployee = service.saveOrUpdate(employee).orElse(new Employee());
		gettingEmployee.setName("Özcan");;
		gettingEmployee.setRecordUpdateTime(new Date());
		Employee updatedEmployee = service.saveOrUpdate(gettingEmployee).orElse(new Employee());
		
		assertThat(updatedEmployee.getName(), not(equalTo("Ali Can")));
		
	}
	

	public Employee getEmployee() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("Ali Can");
		employee.setSurname("Kuştemur");
		employee.setSalary(33f);
		employee.setRecordIsDeleted(false);
		employee.setRecordCreateTime(new Date());
		return employee;
	}

}
