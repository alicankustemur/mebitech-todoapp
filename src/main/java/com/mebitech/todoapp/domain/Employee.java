package com.mebitech.todoapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.mebitech.todoapp.domain.base.AbstractEntity;

@Entity
@Table(name = "EMPLOYEE")
@Where(clause = "RECORD_IS_DELETED = 0")
public class Employee extends AbstractEntity{
	
	public Employee(String name, String surname, Float salary) {
		super();
		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}
	
	public Employee(){
		
	}
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	@Column(name = "SALARY")
	private Float salary;
	
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

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

}
