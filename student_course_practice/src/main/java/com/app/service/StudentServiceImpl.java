package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StudentDaoImpl;
import com.app.pojos.Student;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private StudentDaoImpl studentDao;

	@Override
	public String admitStudent(Student student,int courseId) {
		System.out.println("servc layer : admit student...");
		return studentDao.admitStudent(student,courseId);
	}

	@Override
	public String deleteStudent(Student student) {
		System.out.println("servc layer : delete student...");
		return studentDao.deleteStudent(student);
	}

}
