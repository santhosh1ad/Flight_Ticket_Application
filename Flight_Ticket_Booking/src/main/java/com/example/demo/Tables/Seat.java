package com.example.demo.Tables;

import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_number")
    private int seatNumber;

    @ManyToOne
    @JoinColumn(name = "flight_id") // Adjust the column name based on your database schema
    private Flights flight;

    private boolean booked;

    // Constructors, getters, and setters

    public Seat() {
        // Default constructor
    }

    public Seat(int seatNumber, Flights flight) {
        this.seatNumber = seatNumber;
        this.flight = flight;
        this.booked = false; // Newly created seats are initially not booked
    }

    // Other getters and setters

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
