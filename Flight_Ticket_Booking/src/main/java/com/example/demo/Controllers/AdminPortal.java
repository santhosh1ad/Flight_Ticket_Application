package com.example.demo.Controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Tables.Booking;
import com.example.demo.Tables.Flights;
import com.example.demo.Repository.BookingRepository;
import com.example.demo.Repository.FlightRepository;

@RestController
@RequestMapping("/Admin")
public class AdminPortal {

	@Autowired
	private FlightRepository repo;
	
	@Autowired 
	private BookingRepository bok;

	@GetMapping("/AddFlights")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String addFlight(@RequestParam int flightId, @RequestParam String name,
	        @RequestParam LocalTime departureTime, @RequestParam LocalTime arrivalTime,
	        @RequestParam String start, @RequestParam String end, @RequestParam LocalDate date) {
	    Flights obj = new Flights(flightId, name, departureTime, arrivalTime, start, end, date);
	    repo.save(obj);
	    return "Successfully Added";
	}
	
	/*-------------------------------------------------------------------------------------------------------------------*/
	
	@GetMapping("/ShowBookings")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Booking> ShowHistory(){
		return bok.findAll();
		
	}



}
