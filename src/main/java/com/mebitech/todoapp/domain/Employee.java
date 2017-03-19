package com.mebitech.todoapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.mebitech.todoapp.domain.base.AbstractEntity;

@Entity
@Table(name = "EMPLOYEE")
@Where(clause = "RECORD_IS_DELETED = 0")
public class Employee extends AbstractEntity {

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "SURNAME", nullable = false)
	private String surname;

	@Column(name = "SALARY", nullable = false)
	private String salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

}
