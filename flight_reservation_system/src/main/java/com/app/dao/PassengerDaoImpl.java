package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Card;
import com.app.pojos.Flight;
import com.app.pojos.Passenger;

@Repository
public class PassengerDaoImpl implements IPassengerDao {

	@Autowired
	private EntityManager manager;

	@Override
	public Passenger validatePassenger(String email, String password) {
		String jpql = "select p from Passenger p where p.email=:email and p.password=:password";
		return manager.createQuery(jpql, Passenger.class).setParameter("email", email).setParameter("password", password).getSingleResult();
	}

	@Override
	public List<Flight> getFlightList() {
		String jpql = "select f from Flight f";
		return manager.createQuery(jpql, Flight.class).getResultList();
	}

	@Override
	public List<Flight> getFlightList(String depCity, String arrivalCity) {
		String jpql = "select f from Flight f where f.depCity=:depCity and f.arrivalCity = :arrivalCity";
		return manager.createQuery(jpql, Flight.class).setParameter("depCity", depCity).setParameter("arrivalCity", arrivalCity).getResultList();
	}

	@Override
	public Passenger validatePassAllDetails(String name, String email, String phoneNum) {
		String jpql = "select p from Passenger p where p.name= :name and p.email=:email and p.phoneNum=:phoneNum";
		return manager.createQuery(jpql, Passenger.class).setParameter("name", name).setParameter("email", email).setParameter("phoneNum", phoneNum).getSingleResult();
	}

	@Override
	public Card validateCardDetails(String cardNum, String cardName, LocalDate expDate, String cvv) {
		String jpql = "select c from Card c where c.cardNum= :cardNum and c.cardName=:cardName and c.expDate=:expDate and c.cvv=:cvv";
		return manager.createQuery(jpql, Card.class).setParameter("cardNum", cardNum).setParameter("cardName", cardName).
				setParameter("expDate", expDate).setParameter("cvv", cvv).getSingleResult();
	}


	
	

}
