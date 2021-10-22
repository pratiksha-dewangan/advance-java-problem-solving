package com.app.service;

import com.app.pojos.Account;

public interface IAccountService {
	//create acnt
		String createAccount(int userId, Account accnt);
		//delete a/c
		String closeAccount(int aId);
}
