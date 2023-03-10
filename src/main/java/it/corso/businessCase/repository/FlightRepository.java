package it.corso.businessCase.repository;

import it.corso.businessCase.model.Booking;
import it.corso.businessCase.model.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Integer> {

    List<Flight> findByFromAirportAndToAirportAndFlightDate(String fromAirport, String toAirport, Date date);
    int countTotalSeatsByFlightNumberAndFlightDate(String flightNumber, Date date);
}
