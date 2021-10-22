package com.app.pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	//default constructor
	public BaseEntity() {
		System.out.println("In Base Entity Class.....");
	}
	//parameterised constructor
	public BaseEntity(Integer id) {
		super();
		this.id = id;
	}
	//getter n setter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	//to String
	@Override
	public String toString() {
		return "BaseEntity [id=" + id + "]";
	}	
	
}
