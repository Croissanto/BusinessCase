package it.corso.businessCase.controller;

import it.corso.businessCase.model.Booking;
import it.corso.businessCase.model.dto.BookingDto;
import it.corso.businessCase.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class FlightBookingSystem {

    @Autowired
    BookingRepository bookingRepository;


    @PostMapping("/createBooking")
    public boolean bookFlight(@RequestBody BookingDto dto) {
        try {

            Booking booking = new Booking(dto.getFlightNumber(), dto.getFlightDate(), dto.getPassengerName(),
                    dto.getNumSeats());
            bookingRepository.save(booking);
            return true;
        } catch (Exception e) {
            return false;

        }

    }

    @GetMapping("/bookings/{flightNumber}/{date}")
    public List<Booking> getFlightBookings(@PathVariable("flightNumber") String flightNumber,
                                           @PathVariable("date") Date date) {

        return bookingRepository.findByFlightNumberAndFlightDate(flightNumber, date);
    }

    @GetMapping("/bookings/{passengerName}")
    public List<Booking> getPassengerBooking(@PathVariable("passengerName") String passengerName) {
        return bookingRepository.findByPassengerName(passengerName);

    }

    @GetMapping("/bookings/{fromairport}/{toairport}/{date}")
    public List<Booking> getBookings(@PathVariable("fromairport") String fromairport,
                                     @PathVariable("toairport") String toairport,
                                     @PathVariable("date") Date date) {

        return bookingRepository.findByFromAirportAndToAirportAndFlightDate(fromairport, toairport, date);
    }

    @DeleteMapping("/deleteById/{id}")
    public boolean cancelBooking(@PathVariable("id") int id) {
        try {
            bookingRepository.deleteById(id);
            return true;
        } catch (Exception e) {

            return false;

        }


    }
}
