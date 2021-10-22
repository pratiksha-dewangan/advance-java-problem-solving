package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "flight_tbl")
public class Flight extends BaseEntity{
	
	@Column(name = "airline_name",length = 40)
	private String airlineName;
	@Column(name = "departure_city",length = 30)
	private String depCity;
	@Column(name = "arrival_city",length = 30)
	private String arrivalCity;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate depDate;
	
	@ManyToOne
	@JoinColumn(name = "passenger_id",nullable = false)
	private Passenger passenger;
	
	public Flight() {
		System.out.println("in const. of : "+getClass().getName());
	}

	public Flight(String airlineName, String depCity, String arrivalCity, LocalDate depDate) {
		super();
		this.airlineName = airlineName;
		this.depCity = depCity;
		this.arrivalCity = arrivalCity;
		this.depDate = depDate;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDepCity() {
		return depCity;
	}

	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public LocalDate getDepDate() {
		return depDate;
	}

	public void setDepDate(LocalDate depDate) {
		this.depDate = depDate;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	@Override
	public String toString() {
		return "Flight [id="+getId()+" airlineName=" + airlineName + ", depCity=" + depCity + ", arrivalCity=" + arrivalCity
				+ ", depDate=" + depDate + "]";
	}
	
	
	
}
