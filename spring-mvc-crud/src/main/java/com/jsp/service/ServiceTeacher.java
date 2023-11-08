package com.jsp.service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.ResponseBody;
	import org.springframework.web.servlet.ModelAndView;

	import com.jsp.dao.TeacherDao;
	import com.jsp.dto.Teacher;

	@Controller
	public class ServiceTeacher {
		@Autowired
		TeacherDao dao;
		
		@RequestMapping("/home")
		public ModelAndView homeTeacher() {
			return dao.homeTeacher();
		}
		@RequestMapping("/loadteacher")
		public ModelAndView loadTeacher() {
			return dao.loadTeacher();
		}
		@RequestMapping("/saveteacher")
		public ModelAndView saveTeacher(@ModelAttribute  Teacher teacher) {
			return dao.saveTeacher(teacher);
		}
		@RequestMapping("/displayteacher")
		public ModelAndView getAll() {
			return dao.getAll();
		}
		@RequestMapping("/deleteteacher")
		public ModelAndView deleteTeacher(@RequestParam int id) {
			return dao.deleteTeacher(id);
		}
		@RequestMapping("/getbyid")
		public ModelAndView getById(@RequestParam int id) {
			return dao.getById(id);
		}
		@RequestMapping("/updateteacher")
		public ModelAndView update(@ModelAttribute Teacher teacher,@RequestParam int tid) {
			return dao.update(teacher,tid);
		}
	}


