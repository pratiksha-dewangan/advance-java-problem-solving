package com.app.dao;

import com.app.pojos.Account;

public interface IAccountDao {
	//create acnt
	String createAccount(int userId, Account accnt);
	//delete a/c
	String closeAccount(Account acnt);
	
	//get account detrails by id
	Account getAccountDetails(int aid);

}
