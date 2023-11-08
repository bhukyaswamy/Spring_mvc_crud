  package com.jsp.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;

	import com.jsp.service.ServiceTeacher;

	@Controller
	public class TestProject {
		@Autowired
		ServiceTeacher service;
		@RequestMapping("/test")
		public ModelAndView testProject() {
			ModelAndView mav = new ModelAndView("/home");
			return  mav;
		}
	}

