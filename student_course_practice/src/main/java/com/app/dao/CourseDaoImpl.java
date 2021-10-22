package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Course;
import com.app.pojos.Student;

@Repository
public class CourseDaoImpl implements ICourseDao{

	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Course> getAllCourse() {
		String jpql = "select c from Course c";
		return manager.createQuery(jpql, Course.class).getResultList();
	}

	@Override
	public String deleteCourse(Course course) {
			manager.remove(course);
		return "Course deleted successfully....";
	}

	@Override
	public Course getCourseById(int id) {
		return manager.find(Course.class, id);
	}

	@Override
	public List<Student> getAllStudent() {
		String jpql = "select s from Student s";
		return manager.createQuery(jpql, Student.class).getResultList();
		
	}

	@Override
	public Course getAllCourseAndStudentsWithInIt(String title) {
		String jpql = "select c from Course c left outer join fetch c.student where c.title =:title";
		return manager.createQuery(jpql, Course.class).setParameter("title", title).getSingleResult();
	}

	
}
