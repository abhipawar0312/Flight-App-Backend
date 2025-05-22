package com.example.FlightApplication.flight.service;

import com.example.FlightApplication.flight.dto.SyntheseCompanyDto;
import com.example.FlightApplication.flight.model.Flight;
import com.example.FlightApplication.flight.model.FlightCriteria;
import com.example.FlightApplication.flight.model.SynthesisCriteria;

import java.util.List;
import java.util.Optional;

public interface FlightService {

    Flight addFlight(Flight flight);

    List<Flight> getAllFlights();

    List<Flight> searchFlight(FlightCriteria flightCriteria);


   Optional<Flight> getFlight(Long idFlight);

   Long getNumberFlight(SynthesisCriteria synthesisCriteria);
   List<SyntheseCompanyDto> getNbsFlightByCompany(SynthesisCriteria synthesisCriteria);

}
