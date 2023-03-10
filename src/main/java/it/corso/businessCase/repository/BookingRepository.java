package it.corso.businessCase.repository;

import it.corso.businessCase.model.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

    List<Booking> findByFlightNumberAndFlightDate(String flightNumber, Date date);
    List<Booking> findByPassengerName(String passengerName);
    int countNumSeatsByFlightNumberAndFlightDate(String flightNumber, Date date);
}
