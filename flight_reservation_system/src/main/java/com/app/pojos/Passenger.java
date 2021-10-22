package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "passenger_tbl")
public class Passenger extends BaseEntity{
	
	
	@Column(length = 30)
	private String name;
	@Column(length = 30)
	private String email;
	@Column(length = 30)
	private String password;
	@Column(name = "phone_num",length = 20)
	private String phoneNum;
	
	//mapp
	@OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
	List<Flight> flights = new ArrayList<>();
	
	@Embedded
	private Card card;
	
	public Passenger() {
		System.out.println("in const. of : " +getClass().getName());
	}

	public Passenger(String name, String email, String password, String phoneNum) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNum = phoneNum;
	}

	//helper methods 
	public void addFlight(Flight flight) {
		flights.add(flight);
		flight.setPassenger(this);
	}
	
	public void remFlight(Flight flight) {
		flights.remove(flight);
		flight.setPassenger(null);
	}
	
	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Passenger [id="+getId()+"name=" + name + ", email=" + email + ", password=" + password + ", phoneNum=" + phoneNum
				+ "]";
	}
	
}
