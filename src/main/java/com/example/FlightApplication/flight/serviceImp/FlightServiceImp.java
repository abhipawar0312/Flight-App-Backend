package com.example.FlightApplication.flight.serviceImp;

import com.example.FlightApplication.flight.model.Flight;
import com.example.FlightApplication.flight.repository.FlightRepository;
import com.example.FlightApplication.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImp implements FlightService {

    @Autowired
    private FlightRepository flightRepository;
    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);

    }
}
