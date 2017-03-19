package com.mebitech.todoapp.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mebitech.todoapp.domain.Department;
import com.mebitech.todoapp.repository.DepartmentRepository;
import com.mebitech.todoapp.service.DepartmentService;
import com.mebitech.todoapp.service.base.AbstractBaseServiceImpl;

@Transactional
@Service
public class DepartmentServiceImpl extends AbstractBaseServiceImpl<Department, Long> implements DepartmentService {
	
	public DepartmentServiceImpl(DepartmentRepository repository) {
		super(repository);
	}
	
}
