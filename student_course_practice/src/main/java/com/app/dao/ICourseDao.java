package com.app.dao;
import java.util.List;

import com.app.pojos.Course;
import com.app.pojos.Student;
public interface ICourseDao {
	
	//to get list of all courses
	List<Course> getAllCourse();
	
	//delete course
	String deleteCourse(Course course);
	
	//get course by Id
	Course getCourseById(int id);
		
	List<Student> getAllStudent();
	
	//getall course and student with in it
	Course getAllCourseAndStudentsWithInIt(String title);
	
	
}
