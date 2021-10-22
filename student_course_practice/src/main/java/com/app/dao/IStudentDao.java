package com.app.dao;

import com.app.pojos.Student;

public interface IStudentDao {
	
	String admitStudent(Student student,int courseId);
	
	String deleteStudent(Student student);
	


}
