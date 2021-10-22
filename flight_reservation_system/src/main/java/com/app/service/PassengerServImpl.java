package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IPassengerDao;
import com.app.pojos.Card;
import com.app.pojos.Flight;
import com.app.pojos.Passenger;

@Service
@Transactional
public class PassengerServImpl implements IPassengerService{

	@Autowired
	private IPassengerDao passengerDao;
	
	@Override
	public Passenger validatePassenger(String email, String password) {
		System.out.println("in service layer");
		return passengerDao.validatePassenger(email, password);
	}

	@Override
	public List<Flight> getFlightList() {
		System.out.println("in service layer");
		return passengerDao.getFlightList();
	}

	@Override
	public List<Flight> getFlightList(String depCity, String arrivalCity) {
		System.out.println("in service layer");
		return passengerDao.getFlightList(depCity, arrivalCity);
	}

	@Override
	public Passenger validatePassAllDetails(String name, String email, String phoneNum) {
		System.out.println("in service layer");
		return passengerDao.validatePassAllDetails(name, email, phoneNum);
	}

	@Override
	public Card validateCardDetails(String cardNum, String cardName, LocalDate expDate, String cvv) {
		System.out.println("in service layer");
		return passengerDao.validateCardDetails(cardNum, cardName, expDate, cvv);
	}


}

