package com.example.FlightApplication.flight.serviceImp;

import com.example.FlightApplication.flight.dto.SyntheseCompanyDto;
import com.example.FlightApplication.flight.model.Flight;
import com.example.FlightApplication.flight.model.FlightCriteria;
import com.example.FlightApplication.flight.model.SynthesisCriteria;
import com.example.FlightApplication.flight.repository.FlightRepository;
import com.example.FlightApplication.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Flight> getFlight(Long idFlight) {
        Optional<Flight> flights =flightRepository.findById(idFlight);
        return  flightRepository.findById(idFlight);
    }

    @Override
    public Long getNumberFlight(SynthesisCriteria synthesisCriteria) {
        return flightRepository.getNumberFlight(synthesisCriteria );
    }

    @Override
    public List<SyntheseCompanyDto> getNbsFlightByCompany(SynthesisCriteria synthesisCriteria) {
        return flightRepository.getNbsFlightByCompany(synthesisCriteria);
    }


}
