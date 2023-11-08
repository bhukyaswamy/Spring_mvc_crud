package com.jsp.dao;

	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Query;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.servlet.ModelAndView;
	import org.springframework.web.servlet.config.MvcNamespaceHandler;

	import com.jsp.dto.Teacher;

	@Controller
	public class TeacherDao {
		@Autowired
		EntityManagerFactory eMF;
		
		public ModelAndView homeTeacher() {
			ModelAndView mav = new ModelAndView("home.jsp");
			Teacher teacher = new Teacher();
			mav.addObject("teacher",teacher);
			return mav;
		}
		
		public ModelAndView loadTeacher() {
			ModelAndView mav = new ModelAndView("register.jsp");
			mav.addObject("teacher", new Teacher());
			return mav;
		}
		
		public ModelAndView saveTeacher(@ModelAttribute  Teacher teacher) {
			
			EntityManager eM = eMF.createEntityManager();
			
			EntityTransaction eT= eM.getTransaction();
			
			Query q = eM.createQuery("select a from Teacher a");
			
			List<Teacher> list = q.getResultList();
			boolean b=true;
			for(Teacher t : list) {
				if(t.getId()==teacher.getId())
					b=false;
			}
			
			if(b && teacher.getAge()!=0) {
				eT.begin();
				eM.persist(teacher);
				eT.commit();
				ModelAndView mav = new ModelAndView("home.jsp");
				return mav;
				
			}else {
				
				ModelAndView mav = new ModelAndView("/loadteacher");
				return mav;
			}
		}
		
		public ModelAndView getAll() {
			EntityManager eM = eMF.createEntityManager();
			
			Query q = eM.createQuery("select a from Teacher a");
			
			List<Teacher> list = q.getResultList();
			
			ModelAndView mav = new ModelAndView("display.jsp");
			mav.addObject("list",list);
			return mav;
		}
		
		public ModelAndView deleteTeacher(@RequestParam int id) {
			EntityManager eM = eMF.createEntityManager();
			EntityTransaction eT = eM.getTransaction();
			
			Teacher teacher = eM.find(Teacher.class,id);
			
			eT.begin();
			eM.remove(teacher);
			eT.commit();
			
			ModelAndView mav = new ModelAndView("/displayteacher");
			return mav;
		}
		
		public ModelAndView getById(int id) {
			EntityManager eM = eMF.createEntityManager();
			EntityTransaction eT = eM.getTransaction();
			
			Teacher teacher = eM.find(Teacher.class,id);
			ModelAndView mav = new ModelAndView("updateteacher.jsp");
			mav.addObject("update",teacher);
			return mav;
		}
		
		public ModelAndView update(Teacher teacher,int id) {
			EntityManager eM = eMF.createEntityManager();
			EntityTransaction eT = eM.getTransaction();	
			
			if(id==teacher.getId()) {
				eT.begin();
				eM.merge(teacher);
				eT.commit();
			
				ModelAndView mav = new ModelAndView("/displayteacher");
				return mav;
			}else {
				ModelAndView mav = new ModelAndView("/displayteacher");
				return mav;
			}
		}
	}



