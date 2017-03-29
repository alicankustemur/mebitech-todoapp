package com.mebitech.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mebitech.todoapp.service.CreateTestDataService;

@Controller
public class IndexController {
	
	@Autowired
	private CreateTestDataService createTestData;
	
	@RequestMapping("/")
	public ModelAndView index(ModelAndView modelAndView) {
		createTestData.create();
		modelAndView.addObject("title","Mebitech Todo App");
		modelAndView.setViewName("index");
		return modelAndView;
	}

}
