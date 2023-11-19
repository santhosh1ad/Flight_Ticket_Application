package com.example.demo.Service;

import com.example.demo.Tables.Flights;
public interface FlightWithSeatCount {
    Flights getFlight();
    Long getSeatCount();
}
