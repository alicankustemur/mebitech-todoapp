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
		modelAndView.setViewName("department");
		return modelAndView;
	}
	
	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	@ResponseBody
	public List<Department> employees() {
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
		Employee employee = employeeService.get(employeeId);
		
		if(!service.isItAvailableDepartmentWithThisEmployee(employee)){
			Department department = new Department();
			department.setName(name);
			department.setDescription(description);
			department.setRecordIsDeleted(false);
			department.setEmployee(employee);
			department.setRecordCreateTime(new Date());
			
			service.saveOrUpdate(department);
		}else{
			return "redirect:/department?error=availableDepartment";
		}
		return "redirect:/department";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST )
	public String updateDepartment(
							  @RequestParam("id") Long id,
							  @RequestParam("name") String name,
							  @RequestParam("description") String description,
							  @RequestParam("employee") Long employeeId){
		
		
		Employee employee = employeeService.get(employeeId);
		if(!service.isItAvailableDepartmentWithThisEmployee(employee)){
			Department department = service.get(id);
			department.setName(name);
			department.setDescription(description);
			department.setEmployee(employee);
			department.setRecordUpdateTime(new Date());
			
			service.saveOrUpdate(department);
		}else{
			return "redirect:/department?error=availableDepartment";
		}
		return "redirect:/department";
	}
	
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	@ResponseBody
	public String error(String error){
		return error;
	}

}
