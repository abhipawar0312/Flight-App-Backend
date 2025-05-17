package com.example.FlightApplication.flight.model;

import com.example.FlightApplication.flight.enumerations.CompanyName;
import com.example.FlightApplication.flight.enumerations.FlightType;
import com.example.FlightApplication.flight.enumerations.TravelType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class FlightCriteria {
    private CompanyName company;
    private FlightType flightType;
    private TravelType travelType;
    private String departureLocation;
    private String arrivalLocation;
    private Double fareMin;
    private Double fareMax;
    private LocalTime flightDurationMin;
    private LocalTime flightDurationMax;
    private String aircraftType;
    private LocalDate departureDateMin;
    private LocalDate arrivalDateMin;
    private LocalDate backDateMin;
    private LocalTime departureTimeMin;
    private LocalTime arrivalTimeMin;
    private LocalTime backTimeMin;
    private LocalDate departureDateMax;
    private LocalDate arrivalDateMax;
    private LocalDate backDateMax;
    private LocalTime departureTimeMax;
    private LocalTime arrivalTimeMax;
    private LocalTime backTimeMax;
    private LocalTime connectionDurationMin;
    private LocalTime connectionDurationMax;
}
