package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Controllers.FlightDetailsDTO;
import com.example.demo.Repository.BookingRepository;
import com.example.demo.Repository.FlightRepository;
import com.example.demo.Repository.SeatRepository;
import com.example.demo.Tables.Flights;
import com.example.demo.Tables.Seat;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.demo.Tables.Booking;

@RestController
public class FlightAvaService {

	@Autowired
	private FlightRepository flightService;
	
	@Autowired
	private SeatRepository seatRepo;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	/*------------------------------------------------------------------------------------------*/
	
	public List<FlightDetailsDTO> getFlightsByDate(LocalDate date) {
		return flightService.findFlightDetailsByDate(date);
	}
	/*------------------------------------------------------------------------------------------*/	
	
	public List<FlightDetailsDTO> getFlightsByName(String name) {
        return flightService.findByNameIgnoreCase(name);
	}
	/*------------------------------------------------------------------------------------------*/
	
	public List<FlightDetailsDTO> getFlightsById(int Id) {
		return flightService.findFlightNameById(Id);
	}

	/*------------------------------------------------------------------------------------------*/
	
	public boolean bookFlight(String flightName, LocalDate flightDate, String username) {
        // Step 1: Check Flight Availability
		boolean check = flightService.existsByNameAndDate(flightName, flightDate);
        if (!check) {// Flight is not available
            return false;
        }
        
//        Flights flight = flightService.findByName(flightName);
//        
//       
//        
//        Seat availableSeat = findAvailableSeat(flight);
//
//        if (availableSeat == null) {
//            return false;
//        }
//
//        availableSeat.setBooked(true);
//        seatRepo.save(availableSeat);


        
        Booking booking = new Booking();
         
        booking.setUsername(username);
           
        booking.setFlight_name(flightName);
 
        booking.setDate(flightDate);
        // Step 3: Save Booking
        bookingRepository.save(booking);
       // Booking successful
        
        return true;
    }
	
	private Seat findAvailableSeat(Flights flight) {
        return flight.getSeats().stream()
                .filter(seat -> !seat.isBooked())
                .findFirst()
                .orElse(null);
    }
	
	
}
