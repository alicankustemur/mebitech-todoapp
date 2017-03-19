package com.mebitech.todoapp.repository;

import org.springframework.stereotype.Repository;

import com.mebitech.todoapp.domain.Employee;
import com.mebitech.todoapp.repository.base.BaseRepository;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee, Long> {
	
}
