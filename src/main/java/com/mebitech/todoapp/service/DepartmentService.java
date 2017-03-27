package com.mebitech.todoapp.service;

import com.mebitech.todoapp.domain.Department;
import com.mebitech.todoapp.domain.Employee;
import com.mebitech.todoapp.service.base.BaseService;

public interface DepartmentService extends BaseService<Department, Long>{
	
	public Department getDepartmentByEmployee(Employee employee);
}
