package com.example.demo.Tables;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("seatNumber")
    private List<Seat> seats = new ArrayList<>();

    @Column(name = "Flight_id", unique = true) // DataIntegrityViolationException
    private int flightId;

    @Column(name = "Flight_Name")
    private String Name;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @Column(name = "departure_location")
    private String departureLocation;

    @Column(name = "arrival_location")
    private String arrivalLocation;

    @Column(name = "date")
    private LocalDate date;

    public Flights() {
        // Default constructor
    }

    public Flights(int flightId, String name, LocalTime departureTime, LocalTime arrivalTime,
                   String departureLocation, String arrivalLocation, LocalDate date) {
        this.flightId = flightId;
        this.Name = name;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.date = date;
    }

    // Other getters and setters...

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    // Other methods...

    // Method to initialize seats for a flight
    public void initializeSeats() {
        for (int i = 1; i <= 60; i++) {
            Seat seat = new Seat(i, this);
            seats.add(seat);
        }
    }
}
