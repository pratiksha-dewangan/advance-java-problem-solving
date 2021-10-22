package com.app.dao;
import com.app.pojos.User;

public interface IUserDao {

	String registerUser(User user);
	User validateUser(String email,String password);
	
}
