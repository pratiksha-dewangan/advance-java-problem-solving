package com.app.dao;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Account;
import com.app.pojos.User;

@Repository
public class AccountDaoImpl implements IAccountDao{
	
	@Autowired // to inject dependency
	private EntityManager manager;
	
	@Override
	public String createAccount(int userId, Account accnt) {
		String mesg = "Account creation failed";
		User user= manager.find(User.class, userId);
		if(user != null) {
			user.addBankAccount(accnt);
			mesg = "Account successfullt created...";
		}
		return mesg;
	}

	@Override
	public String closeAccount(Account acnt) {
		String mesg="account closed..!!";
		manager.remove(acnt);
		return mesg;
	}

	@Override
	public Account getAccountDetails(int aid) {
		return manager.find(Account.class, aid);
	}

}
