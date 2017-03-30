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

import com.mebitech.todoapp.domain.Employee;
import com.mebitech.todoapp.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName("employee");
		return modelAndView;
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> employees() {
		return service.getAll();
	}
	
	@RequestMapping(value = "/delete/{id}" , method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id") Long id){
		
		Employee employee = service.get(id);
		employee.setRecordIsDeleted(true);
		employee.setRecordCreateTime(new Date());
		
		service.saveOrUpdate(employee);
		
		return "redirect:/employee";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST )
	public String addEmployee(@RequestParam("name") String name,
							  @RequestParam("surname") String surname,
							  @RequestParam("salary") Float salary){
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setSurname(surname);
		employee.setSalary(salary);
		employee.setRecordIsDeleted(false);
		employee.setRecordCreateTime(new Date());
		
		service.saveOrUpdate(employee);
		
		return "redirect:/employee";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST )
	public String updateEmployee(
							  @RequestParam("id") Long id,
							  @RequestParam("name") String name,
							  @RequestParam("surname") String surname,
							  @RequestParam("salary") Float salary){
		
		Employee employee = service.get(id);
		employee.setName(name);
		employee.setSurname(surname);
		employee.setSalary(salary);
		employee.setRecordUpdateTime(new Date());
			
		service.saveOrUpdate(employee);
		
		return "redirect:/employee";
	}
	

}
