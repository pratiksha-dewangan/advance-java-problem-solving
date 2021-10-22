package com.app.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.CourseDaoImpl;
import com.app.pojos.Course;
import com.app.pojos.Student;

@Service
@Transactional
public class CourseServiceImpl implements ICourseService{

	@Autowired
	private CourseDaoImpl courseDao;
	
	@Override
	public List<Course> getAllCourse() {
		System.out.println("servc layer : course servc");
		return courseDao.getAllCourse();
	}

	@Override
	public String deleteCourse(int id) {
		System.out.println("servc layer : course servc");
		Course course = courseDao.getCourseById(id);
		if(course != null)
			courseDao.deleteCourse(course);
		return "Course deleted successfully....";
	}

	@Override
	public Course getCourseById(int id) {
		// TODO Auto-generated method stub
		return courseDao.getCourseById(id);
	}

	@Override
	public List<Student> getAllStudent() {
		return courseDao.getAllStudent();
	}

	@Override
	public Course getAllCourseAndStudentsWithInIt(String title) {
		
		return courseDao.getAllCourseAndStudentsWithInIt(title);
	}

	

	

}
