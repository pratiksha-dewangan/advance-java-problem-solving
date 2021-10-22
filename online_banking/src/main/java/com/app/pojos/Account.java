package com.app.pojos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accnt_tbl")
public class Account extends BaseEntity {

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private AccountType type;
	@Column
	private double balance;
	
	@Column(name = "acct_num")
	private String accountNum;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable = false)
	private User accnt_owner;
	
	public User getAccnt_owner() {
		return accnt_owner;
	}

	public void setAccnt_owner(User accnt_owner) {
		this.accnt_owner = accnt_owner;
	}

	public Account() {
		System.out.println("In account pojo....");
	}

	public Account(AccountType type, double balance) {
		super();
		this.type = type;
		this.balance = balance;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id= " +getId()+"type=" + type + ", balance=" + balance + ", accountNum=" + accountNum + ", accnt_owner="
				+ accnt_owner + "]";
	}

	
}
