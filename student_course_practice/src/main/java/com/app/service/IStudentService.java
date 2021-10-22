package com.app.service;

import com.app.pojos.Student;


public interface IStudentService {

	String admitStudent(Student student,int courseId);
	
	String deleteStudent(Student student);
	
	
}
