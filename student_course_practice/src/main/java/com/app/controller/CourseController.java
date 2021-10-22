package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Course;
import com.app.service.CourseServiceImpl;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseServiceImpl courseService;
	
	public CourseController() {
		System.out.println("in CC");
	}
	
	@GetMapping("/list")
	public String showAllCourse(Model map) {
		//req
		map.addAttribute("message","Redirecting from Index Page to List page........");
		map.addAttribute("course_list", courseService.getAllCourse());
		return "/course/list";
	}
	
	
	@GetMapping("/delete")
	public String deleteCourse(@RequestParam int id, RedirectAttributes flashMap) {
		System.out.println("in delete course..!!");
		flashMap.addFlashAttribute("message",courseService.deleteCourse(id));
		return "redirect:/course/list";
	}
	
	@GetMapping("/details")
	public String getAllDetails(@RequestParam int id,Model map) {
		map.addAttribute("message","from List Page to details page........");
		Course course=courseService.getCourseById(id);
		map.addAttribute("course",course);
		map.addAttribute("student_list", course.getStudent());
		return "/course/details";
	}
}
