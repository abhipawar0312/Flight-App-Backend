package com.example.FlightApplication.flight.serviceImp;

import com.example.FlightApplication.flight.model.Flight;
import com.example.FlightApplication.flight.model.FlightCriteria;
import com.example.FlightApplication.flight.repository.FlightRepository;
import com.example.FlightApplication.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FlightServiceImp implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public FlightServiceImp(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }
    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public List<Flight> searchFlight(FlightCriteria flightCriteria) {
        return flightRepository.searchFlights(flightCriteria);
    }


}
