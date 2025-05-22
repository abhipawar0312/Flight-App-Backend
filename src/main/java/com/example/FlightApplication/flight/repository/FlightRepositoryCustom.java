package com.example.FlightApplication.flight.repository;

import com.example.FlightApplication.flight.dto.SyntheseCompanyDto;
import com.example.FlightApplication.flight.model.Flight;
import com.example.FlightApplication.flight.model.FlightCriteria;
import com.example.FlightApplication.flight.model.SynthesisCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepositoryCustom {

    List<Flight> searchFlights(FlightCriteria flightCriteria);
    Long getNumberFlight(SynthesisCriteria synthesisCriteria);
    List<SyntheseCompanyDto> getNbsFlightByCompany(SynthesisCriteria synthesisCriteria);

}
