package com.example.demo.Tables;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String username;
    
	private String Flight_name;
	
	private LocalDate Date;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getFlight_name() {
		return Flight_name;
	}


	public void setFlight_name(String flight_name) {
		Flight_name = flight_name;
	}


	public LocalDate getDate() {
		return Date;
	}


	public void setDate(LocalDate date) {
		Date = date;
	}


	public Booking(String username, String flight_name, LocalDate date) {
		super();
		this.username = username;
		Flight_name = flight_name;
		Date = date;
	}


	public Booking() {
	}
	

}
