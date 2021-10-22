package com.app.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Student;
import com.app.service.StudentServiceImpl;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentServiceImpl studentService;
	
	public StudentController() {
		System.out.println("in student's controller const. ");
	}
	
	@GetMapping("/add")
	public String showStudentAddForm(Student student,HttpSession hs,@RequestParam int courseId) {
		System.out.println("in student show form..."+student+" "+courseId);
				hs.setAttribute("course_id", courseId);
				return "/student/add";
	}
	
	@PostMapping("/add")
	public String processStudentAddForm(Student studentDetails,RedirectAttributes flashMap, Model map,HttpSession hs) {
		System.out.println("in student process form..");
		int courseId=(Integer) hs.getAttribute("course_id");
		System.out.println(studentDetails+" "+courseId);	
		//Below validation logic has to be pushed in service layer !
		if(studentDetails.getCgpa()>7 && studentDetails.getDob().isAfter(LocalDate.parse("1990-01-01"))) {
			map.addAttribute("message", "Student admission done");
			flashMap.addFlashAttribute(studentService.admitStudent(studentDetails,courseId));			
			return "redirect:/course/list";
			}	
		else {
			map.addAttribute("message", "Student cannot be admitted....");
			return "/student/add";
		}
				
	}	
	
}
