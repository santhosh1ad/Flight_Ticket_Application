package com.example.demo.Controllers;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.Repository.FlightRepository;
import com.example.demo.Service.FlightAvaService;

import com.example.demo.Tables.Flights;

@RestController
@RequestMapping("/Home")
public class Pages {

	@Autowired
	FlightAvaService service;

	@GetMapping("/flights/date")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<List<FlightDetailsDTO>> getFlightsByDate(
			@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

		List<FlightDetailsDTO> flights = service.getFlightsByDate(date);

		if (flights.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 No Content if no flights are found
		} else {
			return ResponseEntity.ok(flights);
		}
	}
	/*---------------------------------------------------------------------------------------------------------------------------------*/

	@GetMapping("/flights/{flightId}")
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<List<FlightDetailsDTO>> getFlightsById(@PathVariable int flightId) {
		List<FlightDetailsDTO> flights = service.getFlightsById(flightId);

		if (flights.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);// Return 204 No Content if no flights are found
		} else {
			return ResponseEntity.ok(flights);
		}
	}

	/* --------------------------------------------------------------------------------------------------------------------------------- */
	@GetMapping("/flights/name")
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<List<FlightDetailsDTO>> getFlightsByName(@RequestParam String name) {
		List<FlightDetailsDTO> flights = service.getFlightsByName(name);

		if (flights.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);// Return 204 No Content if no flights are found
		} else {
			return ResponseEntity.ok(flights);
		}
	}

	/*----------------------------------------------------------------------------------------------------------------------------------*/

	@GetMapping("flights/Book/")
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<String> bookOneWay(@RequestParam String name,
			@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
			@RequestParam String user) {

		try {
			// Step 1: Check Flight Availability
			boolean check = service.bookFlight(name, date, user);

			if (!check) {
				String message = "Flight not booked successfully for user: " + user;
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
			}

			String message = "Flight ticket  booked successfully for : " + user;
			return ResponseEntity.ok(message);
		} catch (Exception e) {
			// Handle exceptions appropriately
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An error occurred during the booking process.");
		}
	}

}
