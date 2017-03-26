package com.mebitech.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.addObject("title","Mebitech Todo App");
		modelAndView.setViewName("index");
		return modelAndView;
	}

}
