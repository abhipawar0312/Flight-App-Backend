package com.example.FlightApplication.flight.repository;

import com.example.FlightApplication.flight.model.Flight;
import com.example.FlightApplication.flight.model.FlightCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepositoryCustom {

    List<Flight> searchFlights(FlightCriteria flightCriteria);
}
