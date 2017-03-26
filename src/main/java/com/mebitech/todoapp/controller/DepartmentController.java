package com.mebitech.todoapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mebitech.todoapp.domain.Department;
import com.mebitech.todoapp.domain.Employee;
import com.mebitech.todoapp.service.DepartmentService;
import com.mebitech.todoapp.service.EmployeeService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView) {
		if(service.getAll().size() == 0){
			Department department  = new Department();
			department.setName("Baggins");
			department.setDescription("The Baggins clan traced their origin to the first recorded Baggins, one Balbo Baggins, who was born in or near Hobbiton in S.R. 1167.");
			Employee employee = employeeService.get(1L);
			department.setEmployee(employee);
			department.setRecordIsDeleted(false);
			department.setRecordCreateTime(new Date());
			
			service.saveOrUpdate(department);
		}
		modelAndView.setViewName("department");
		return modelAndView;
	}
	
	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	@ResponseBody
	public List<Department> employees(ModelAndView modelAndView) {
		return service.getAll();
	}
	
	@RequestMapping(value = "/delete/{id}" , method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id") Long id){
		
		Department department = service.get(id);
		department.setRecordIsDeleted(true);
		department.setRecordCreateTime(new Date());
		
		service.saveOrUpdate(department);
		
		return "redirect:/department";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST )
	public String addDepartment(
							  @RequestParam("name") String name,
							  @RequestParam("description") String description,
							  @RequestParam("employee") Long employeeId){
		Department department = new Department();
		department.setName(name);
		department.setDescription(description);
		department.setRecordIsDeleted(false);
		Employee employee = employeeService.get(employeeId);
		department.setEmployee(employee);
		department.setRecordCreateTime(new Date());
		
		service.saveOrUpdate(department);
		
		return "redirect:/department";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST )
	public String updateDepartment(
							  @RequestParam("id") Long id,
							  @RequestParam("name") String name,
							  @RequestParam("description") String description,
							  @RequestParam("employee") Long employeeId){
		
		Department department = service.get(id);
		department.setName(name);
		department.setDescription(description);
		Employee employee = employeeService.get(employeeId);
		department.setEmployee(employee);
		department.setRecordUpdateTime(new Date());
			
		service.saveOrUpdate(department);
		
		return "redirect:/department";
	}
	

}