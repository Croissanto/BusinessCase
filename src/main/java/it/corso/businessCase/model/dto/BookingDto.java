package it.corso.businessCase.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
public class BookingDto {

    private Date flightDate;
    private Time departureTime;
    private Time arrivalTime;
    private String fromAirport;
    private String toAirport;
    private int numSeats;
    private String passengerName;
    private String flightNumber;
}
