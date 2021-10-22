package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //mandatory JPA
@Table(name = "vendor_tbl")
public class Vendor extends BaseEntity{
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
	
	
	@OneToMany(mappedBy = "registeredVendor",cascade = CascadeType.ALL , orphanRemoval = true)
	//fetch = FetchType.EAGER --
	private List<BankAccount> bankacct = new ArrayList<>();
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


	public List<BankAccount> getBankacct() {
		return bankacct;
	}


	public void setBankacct(List<BankAccount> bankacct) {
		this.bankacct = bankacct;
	}

	/*public void addStudent(Student student)
	{
		//parent --> child
		students.add(student);
		//child --> parent
		student.setSelectedCourse(this);		
	}
	public void removeStudent(Student student)
	{
		//parent ----X  -----> child
		students.remove(student);
		//child --X--> parent
		student.setSelectedCourse(null);		
	}
	*/

	@Override
	public String toString() {
		return "Vendor [id ="+ getId()+" name=" + name + ", email=" + email + ", password=" + password + ", regAmount="
				+ regAmount + ", regDate=" + regDate + "]";
	}
	
}
