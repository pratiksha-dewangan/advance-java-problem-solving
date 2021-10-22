package pojos;

import java.time.LocalDate;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //mandatory JPA
@Table(name = "vendor_tbl")
public class Vendor {
	//Add JPA annotations
	//id (Long)
	@Id//mandatory ann of JPA
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//   name (string)  
	@Column(length = 20)
	private String name;
	// email  (string : unique) 
	@Column(length = 20,unique = true)
	private String email;
	//password(string)   
	@Column(length = 20)
	private String password;
	//regAmount (double)
	@Column(name = "reg_amount")
	private double regAmount;
	// regDate (LocalDate)
	@Column(name = "reg_date")
	private LocalDate regDate;
	
	public Vendor() {
		System.out.println("In vendor's constructor.....");
	}
	
	
	public Vendor(String name, String email, String password, double regAmount, LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", regAmount="
				+ regAmount + ", regDate=" + regDate + "]";
	}

	
	
}
