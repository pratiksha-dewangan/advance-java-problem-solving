package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "course_tbl")
public class Course extends BaseEntity{
	
	@Column(length = 20)
	private String title;
	@Column(name="reg_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate regDate;
	@Column(name = "course_type")
	
	//parent -one -inverse-(4 attr)
	@OneToMany(mappedBy = "selected_course", cascade = CascadeType.ALL , orphanRemoval = true, fetch = FetchType.EAGER)
	List<Student> student = new ArrayList<>();
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String title, LocalDate regDate) {
		super();
		this.title = title;
		this.regDate = regDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}


	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	//helper method
	public void addStudent(Student addstudent) {
		
		student.add(addstudent);
		addstudent.setSelected_course(this);
	}
	
	public void removeStudent(Student remstudent) {
		student.remove(remstudent);
		remstudent.setSelected_course(null);
	}
	
	@Override
	public String toString() {
		return "Course [id= "+getId()+"title=" + title + ", regDate=" + regDate + "]";
	}	
	

}
