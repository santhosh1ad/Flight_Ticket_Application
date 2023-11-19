# Flight Ticket Application
Flight Ticket Application is a Spring Boot application that showcases REST API development using Spring MVC and Spring Data JPA, leveraging Java 8 features.

## Features:
The application consists of the following endpoints:

/Home/flights/date - Users can search for flights based on the flight date. Example: localhost:8080/Home/flights/2023-10-11 (Date format: "yyyy-mm-dd").

/Home/flights/{flightId} - Users can search for flights by providing a unique flight ID. Example: localhost:8080/Home/flights/1001.

/flights/name - Users can search for flights by flight name. Example: localhost:8080/Home/flights/name?name=Cargo.

/Home/flights/Book/ - Users can book a flight by specifying the flight name and departure date. The booking will only succeed if the given flight on the specified date is available; otherwise, it returns false.

Note: These APIs are accessible only to authorized users, specifically Admin.

/NewUser/add - This serves as a signup page where users can register their details in the database. This page is accessible without requiring authorization.

/Admin/AddFlights - Admins can use this endpoint to add new flights to the database. Example: http://localhost:8080/Admin/AddFlights.

/Admin/ShowBookings - Admins can view booking details using this endpoint. Example: http://localhost:8080/Admin/ShowBookings.

Note: These Admin-specific APIs (6, 7) are accessible only to authorized Admin users.

# Technologies Used:
Java (Programming Language)
Spring Boot (Application Platform)
Spring Data JPA (Data Persistence)
MySQL (Database)

# Prerequisites:
Ensure you have the following installed:
sts(Tool)
Java 8
Maven 3


# DataBase 
Using H2 in-memory database, which (database as well as data) will be removed from memory when the application goes down.
While the application is running, you can access the H2 Console if you want to see the data outside the application.

# Entity Classes

## 1. Seat Class

The `Seat` class represents an individual seat within a flight. Each seat has a unique seat number and can be associated with a specific flight.

### Attributes

- **seatNumber:** The unique number assigned to the seat.
- **flight:** The flight to which the seat belongs.
- **booked:** A boolean indicating whether the seat is booked or not.

### Constructors

- **Default Constructor:** Initializes a seat with default values.
- **Parameterized Constructor:** Takes a seat number and the associated flight.

### Methods

- **getSeatNumber():** Returns the seat number.
- **setSeatNumber(int seatNumber):** Sets the seat number.
- **isBooked():** Returns true if the seat is booked; otherwise, false.
- **setBooked(boolean booked):** Sets the booked status.

## 2. Flights Class

The `Flights` class represents information about a flight. It includes details such as flight ID, name, departure time, arrival time, departure location, arrival location, and date.

### Attributes

- **flightId:** Unique identifier for the flight.
- **Name:** Name or identifier of the flight.
- **departureTime:** Time when the flight departs.
- **arrivalTime:** Time when the flight arrives.
- **departureLocation:** Location from where the flight departs.
- **arrivalLocation:** Location where the flight arrives.
- **date:** Date of the flight.
- **seats:** List of seats associated with the flight.

### Constructors

- **Default Constructor:** Initializes a flight with default values.
- **Parameterized Constructor:** Takes details such as flight ID, name, times, locations, and date.

### Methods

- **getSeats():** Returns the list of seats associated with the flight.
- **setSeats(List<Seat> seats):** Sets the list of seats for the flight.
- **initializeSeats():** Initializes seats for the flight, creating 60 seats by default.

# Relation
Flights (One) ----< Seat (Many)








