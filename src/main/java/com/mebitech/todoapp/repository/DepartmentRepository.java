package com.mebitech.todoapp.repository;

import org.springframework.stereotype.Repository;

import com.mebitech.todoapp.domain.Department;
import com.mebitech.todoapp.repository.base.BaseRepository;

@Repository
public interface DepartmentRepository extends BaseRepository<Department, Long> {
	
}
