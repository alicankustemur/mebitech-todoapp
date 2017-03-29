package com.mebitech.todoapp.test.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mebitech.todoapp.domain.Department;
import com.mebitech.todoapp.domain.Employee;
import com.mebitech.todoapp.domain.Meeting;
import com.mebitech.todoapp.service.CreateTestDataService;
import com.mebitech.todoapp.service.DepartmentService;
import com.mebitech.todoapp.service.EmployeeService;
import com.mebitech.todoapp.service.MeetingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateTestDataServiceTest {

	@Mock
	private EmployeeService employeeService;

	@Mock
	private DepartmentService departmentService;

	@Mock
	private MeetingService meetingService;

	@InjectMocks
	@Autowired
	private CreateTestDataService service;

	@Test
	public void testCreate() throws Exception {
		when(employeeService.getAll()).thenReturn(null);

		List<Employee> employeeList = new ArrayList<Employee>();

		Employee employee = new Employee();
		employee.setId(1L);

		employeeList.add(employee);

		Employee otherEmployee = new Employee();
		otherEmployee.setId(2L);

		employeeList.add(otherEmployee);

		Employee anotherEmployee = new Employee();
		anotherEmployee.setId(3L);

		employeeList.add(anotherEmployee);

		employeeService.saveOrUpdate(employee);
		employeeService.saveOrUpdate(otherEmployee);
		employeeService.saveOrUpdate(anotherEmployee);

		when(employeeService.getAll()).thenReturn(employeeList);
		assertThat(employeeService.getAll().size(), is(equalTo(3)));
		assertThat(employeeService.getAll(), is(equalTo(employeeList)));
		
		when(departmentService.getAll()).thenReturn(null);

		List<Department> departmentList = new ArrayList<Department>();

		Department department = new Department();
		department.setId(1L);
		department.setEmployee(employee);
		departmentList.add(department);

		Department otherDepartment = new Department();
		otherDepartment.setId(2L);
		otherDepartment.setEmployee(otherEmployee);

		departmentList.add(otherDepartment);

		departmentService.saveOrUpdate(department);
		departmentService.saveOrUpdate(otherDepartment);

		when(departmentService.getAll()).thenReturn(departmentList);
		assertThat(departmentService.getAll().size(), is(equalTo(2)));
		assertThat(departmentService.getAll(), is(equalTo(departmentList)));
		
		when(meetingService.getAll()).thenReturn(null);

		Meeting meeting = new Meeting();
		meeting.setId(1L);
		meeting.setDepartment(department);

		meetingService.saveOrUpdate(meeting);

		when(meetingService.get(1L)).thenReturn(meeting);
		
	}

}
