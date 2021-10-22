package com.app.pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_tbl")
public class User extends BaseEntity{
	
	@Column(length = 20)
	private String name;
	@Column(length = 30,unique = true)
	private String email;
	@Column(length = 20)
	private String password;
	
	@OneToMany(mappedBy = "accnt_owner",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
	List<Account> accounts = new ArrayList<>();
	
	
	public User() {
		System.out.println("In User Pojo...");
	}

	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
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
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	//adding helper method 
	public void addBankAccount(Account addAccnt) {
		accounts.add(addAccnt);
		addAccnt.setAccnt_owner(this);
	}
	public void removeBankAcoount(Account remAccnt) {
		accounts.remove(remAccnt);
		remAccnt.setAccnt_owner(null);
	}

	@Override
	public String toString() {
		return "User [id="+getId()+"name=" + name + ", email=" + email + ", password=" + password + "]";
	}

}
