package it.corso.businessCase.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private Date flightDate;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String fromAirport;
    private String toAirport;
    private int numSeats;
    private String passengerName;
    private String flightNumber;

    public Booking(String flightNumber, Date flightDate, String passengerName, int numSeats) {
        this.flightNumber = flightNumber;
        this.flightDate = flightDate;
        this.passengerName = passengerName;
        this.numSeats = numSeats;
    }
}
