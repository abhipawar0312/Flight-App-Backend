package com.example.FlightApplication.flight.controller;

import com.example.FlightApplication.flight.model.Flight;
import com.example.FlightApplication.flight.repository.FlightRepository;
import com.example.FlightApplication.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("flight-webservice/api/z1.o/flights")
public class FlightController {
   @Autowired
    FlightService flightService;

   @PostMapping("/addflight")
    public ResponseEntity<Flight>  addFlight(@RequestBody Flight flight){
       Flight addedFlight = flightService.addFlight(flight);

       return new   ResponseEntity<Flight> (addedFlight, new HttpHeaders(), HttpStatus.OK);

   }
}
