package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service
@Transactional
public class UserServImpl implements IUserService{

	@Autowired
	private  IUserDao userDao;
	
	@Override
	public User validateUser(String email, String password) {
		System.out.println("in service layer : validate user");
		return userDao.validateUser(email, password);		
	}

	@Override
	public String registerUser(User user) {
		userDao.registerUser(user);
		return "new user registered..!!";
	}
	
}
