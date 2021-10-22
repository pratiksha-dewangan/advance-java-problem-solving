package com.app.service;

import java.util.List;

import com.app.pojos.Course;
import com.app.pojos.Student;

public interface ICourseService {
	
	List<Course> getAllCourse();

	//delete course
	String deleteCourse(int id);
	
	//get course
	Course getCourseById(int id);
	
	List<Student> getAllStudent();
	Course getAllCourseAndStudentsWithInIt(String title);
}
