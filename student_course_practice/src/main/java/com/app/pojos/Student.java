package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "student_tbl")
public class Student extends BaseEntity{

	@Column(length = 20)
	private String name;
	@Column(length = 50)
	private String address;
	@Column(name="date_of_birth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob; 
	@Column(name = "CGPA")
	private double cgpa;
	
	//many-child-owning (2 ann n 2 attr)
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course selected_course;
	
	public Student() {
		System.out.println("in student ctor");
	}

	public Student(String name, String address, LocalDate dob, double cgpa) {
		super();
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.cgpa = cgpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	
	public Course getSelected_course() {
		return selected_course;
	}

	public void setSelected_course(Course selected_course) {
		this.selected_course = selected_course;
	}

	@Override
	public String toString() {
		return "Student [id= "+getId()+"name=" + name + ", address=" + address + ", dob=" + dob + ", cgpa=" + cgpa + "]";
	}
	
}
