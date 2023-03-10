package it.corso.businessCase.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Flight {

    @Id
    private int Id;
    private Date flightDate;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String fromAirport;
    private String toAirport;
    private int totalSeats;
    private String flightNumber;


}
