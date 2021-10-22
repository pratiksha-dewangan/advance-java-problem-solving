package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Card;
import com.app.pojos.Flight;
import com.app.pojos.Passenger;

public interface IPassengerService {

	Passenger validatePassenger(String email, String password);
	List<Flight> getFlightList();
	List<Flight> getFlightList(String depCity, String arrivalCity);
	Passenger validatePassAllDetails(String name, String email, String phoneNum);
	Card validateCardDetails(String cardNum,String cardName, LocalDate expDate,String cvv);
}
