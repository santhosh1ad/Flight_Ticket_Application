package com.example.demo.Controllers;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightDetailsDTO {

    private String flightName;
    private String departureLocation;
    private String arrivalLocation;
    public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	private LocalTime departureTime;
    private LocalTime arrivalTime;
    private LocalDate date;

    // Constructors, getters, and setters
    
    public FlightDetailsDTO(String flightName, String departureLocation, String arrivalLocation,
                             LocalTime departureTime, LocalTime arrivalTime, LocalDate date) {
        this.flightName = flightName;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.date = date;
    }

    // Getters and setters (generate them using your IDE or write them manually)
}
