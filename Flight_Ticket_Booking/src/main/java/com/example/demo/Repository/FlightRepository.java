package com.example.demo.Repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Controllers.FlightDetailsDTO;
import com.example.demo.Tables.Flights;

public interface FlightRepository extends JpaRepository<Flights, Long> {
    
    @Query("SELECT new com.example.demo.Controllers.FlightDetailsDTO(f.Name, f.departureLocation, f.arrivalLocation, f.departureTime, f.arrivalTime, f.date) FROM Flights f WHERE f.date = :date")
    List<FlightDetailsDTO> findFlightDetailsByDate(@Param("date") LocalDate date);

	 @Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END FROM Flights f WHERE f.Name = :name AND f.date = :date")
	 boolean existsByNameAndDate(@Param("name") String name, @Param("date") LocalDate date);

     @Query("SELECT new com.example.demo.Controllers.FlightDetailsDTO(f.Name, f.departureLocation, f.arrivalLocation, f.departureTime, f.arrivalTime, f.date) FROM Flights f WHERE f.flightId = :flightId")
	 List<FlightDetailsDTO> findFlightNameById(@Param("flightId") int flightId);
 
	 
     @Query("SELECT new com.example.demo.Controllers.FlightDetailsDTO(f.Name, f.departureLocation, f.arrivalLocation, f.departureTime, f.arrivalTime, f.date) FROM Flights f WHERE f.Name = :name")
     List<FlightDetailsDTO> findByNameIgnoreCase(@Param("name") String name);
	// List<Flights> findByNameIgnoreCase(String Name);
	
    // Flights findByName(String Name);

	 //List<Flights> findByName(String ame);
}
