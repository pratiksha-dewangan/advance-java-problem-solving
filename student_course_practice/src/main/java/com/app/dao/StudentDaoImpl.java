package com.app.dao;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Course;
import com.app.pojos.Student;

@Repository
public class StudentDaoImpl implements IStudentDao {

	@Autowired // to inject dependency
	private EntityManager manager;

	@Override
	public String admitStudent(Student student, int courseId) {
		String mesg = "Student admission failed";
		Course course = manager.find(Course.class, courseId);
		if (course != null) {
			course.addStudent(student);
			mesg = "student admission done";
			// manager.persist(student); //save
		}
		return mesg;
	}

	@Override
	public String deleteStudent(Student student) {
		String mesg = "Student removed...!!";
		manager.remove(student); // remove
		return mesg;
	}

}
