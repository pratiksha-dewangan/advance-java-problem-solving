package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.IAccountDao;
import com.app.pojos.Account;

@Service
@Transactional
public class AccountServImpl implements IAccountService{
	
	@Autowired
	private IAccountDao accntDao;
	
	@Override
	public String createAccount(int userId, Account accnt) {
		System.out.println("in serv layer: create accnt");
		return accntDao.createAccount(userId, accnt);
	}

	@Override
	public String closeAccount(int aId) {
		System.out.println("in serv layer: close accnt");
		Account accnt = accntDao.getAccountDetails(aId);
		if(accnt != null)
			accntDao.closeAccount(accnt);
		return "Account deleted succesfuuly";
	}
}
