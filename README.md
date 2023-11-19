Flight Ticket Application
Flight Ticket Application is a Spring Boot application that showcases REST API development using Spring MVC and Spring Data JPA, leveraging Java 8 features.

Features:
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

Technologies Used:
Java (Programming Language)
Spring Boot (Application Platform)
Spring Data JPA (Data Persistence)
MySQL (Database)
Prerequisites:
Ensure you have the following installed:

Java 8
Maven 3




