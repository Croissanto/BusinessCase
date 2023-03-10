package it.corso.businessCase.controller;

import it.corso.businessCase.model.Booking;
import it.corso.businessCase.model.Flight;
import it.corso.businessCase.model.dto.BookingDto;
import it.corso.businessCase.repository.BookingRepository;
import it.corso.businessCase.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class FlightBookingSystem {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    FlightRepository flightRepository;


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
    public List<Flight> getBookings(@PathVariable("fromairport") String fromairport,
                                    @PathVariable("toairport") String toairport,
                                    @PathVariable("date") Date date) {

        return flightRepository.findByFromAirportAndToAirportAndFlightDate(fromairport, toairport, date);
    }

    @GetMapping("/getseats/{flightNumber}/{date}")
    public int getAvailableSeats(@PathVariable("flightNumber") String flightNumber,@PathVariable("date") Date date) {
        int flightTotalSeats = 100; //ipotizzando i posti totali di un ipotetica classe Flight
        int reservedSeats = bookingRepository.countNumSeatsByFlightNumberAndFlightDate(flightNumber, date);

        return flightTotalSeats - reservedSeats;

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
