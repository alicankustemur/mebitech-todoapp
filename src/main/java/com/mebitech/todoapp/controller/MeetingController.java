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
import com.mebitech.todoapp.domain.Meeting;
import com.mebitech.todoapp.service.DepartmentService;
import com.mebitech.todoapp.service.MeetingService;

@Controller
@RequestMapping("/meeting")
public class MeetingController {
	
	@Autowired
	private MeetingService service;
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName("meeting");
		return modelAndView;
	}
	
	@RequestMapping(value = "/meetings", method = RequestMethod.GET)
	@ResponseBody
	public List<Meeting> meetings(ModelAndView modelAndView) {
		return service.getAll();
	}
	
	@RequestMapping(value = "/delete/{id}" , method = RequestMethod.GET)
	public String deleteMeeting(@PathVariable("id") Long id){
		
		Meeting meeting = service.get(id);
		meeting.setRecordIsDeleted(true);
		meeting.setRecordUpdateTime(new Date());
		
		service.saveOrUpdate(meeting);
		
		return "redirect:/meeting";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST )
	public String addMeeting(
							  @RequestParam("name") String name,
							  @RequestParam("description") String description,
							  @RequestParam("department") Long departmentId){
		
		Meeting meeting = new Meeting();
		meeting.setName(name);
		meeting.setDescription(description);
		Department department = departmentService.get(departmentId);
		meeting.setDepartment(department);
		meeting.setRecordIsDeleted(false);
		meeting.setRecordCreateTime(new Date());
		
		service.saveOrUpdate(meeting);
		
		return "redirect:/meeting";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST )
	public String updateMeeting(
							  @RequestParam("id") Long id,
							  @RequestParam("name") String name,
							  @RequestParam("description") String description,
							  @RequestParam("department") Long deparmentId){
			
		Meeting meeting = service.get(id);
		meeting.setName(name);
		meeting.setDescription(description);
		Department department = departmentService.get(deparmentId);
		meeting.setDepartment(department);
		meeting.setRecordIsDeleted(false);
		meeting.setRecordUpdateTime(new Date());
		
		service.saveOrUpdate(meeting);
		
		return "redirect:/meeting";
	}
	

}
