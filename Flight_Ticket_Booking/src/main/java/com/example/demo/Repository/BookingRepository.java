package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Tables.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

}

