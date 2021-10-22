package com.app.dao;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.pojos.User;

@Repository
public class UserImplDao implements IUserDao{
	
	@Autowired
	private EntityManager manager;

	@Override
	public String registerUser(User user) {
		System.out.println("in dao layer : register user");
		String mesg="new user registered..";
		manager.persist(user);
		return mesg;
	}

	@Override
	public User validateUser(String email, String password) {
		System.out.println("in dao layer: validate user");
		String jpql = "select u from User u where u.email=:email and u.password=:password";
		return manager.createQuery(jpql, User.class).setParameter("email", email).setParameter("password", password).getSingleResult();	
	}

	
}
