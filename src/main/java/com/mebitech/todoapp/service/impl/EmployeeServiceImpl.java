package com.mebitech.todoapp.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mebitech.todoapp.domain.Employee;
import com.mebitech.todoapp.repository.EmployeeRepository;
import com.mebitech.todoapp.service.EmployeeService;
import com.mebitech.todoapp.service.base.BaseServiceImpl;

@Transactional
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee, Long> implements EmployeeService {
	
	public EmployeeServiceImpl(EmployeeRepository repository) {
		super(repository);
	}
	
}
