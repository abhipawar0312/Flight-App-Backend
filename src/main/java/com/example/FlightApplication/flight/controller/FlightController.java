package com.example.FlightApplication.flight.controller;

import com.example.FlightApplication.flight.dto.AccountDto;
import com.example.FlightApplication.flight.dto.SyntheseCompanyDto;
import com.example.FlightApplication.flight.model.Account;
import com.example.FlightApplication.flight.model.Flight;
import com.example.FlightApplication.flight.model.FlightCriteria;
import com.example.FlightApplication.flight.model.SynthesisCriteria;
import com.example.FlightApplication.flight.service.AccountService;
import com.example.FlightApplication.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("flight-webservice/api/z1.o/flights")
public class FlightController {
   @Autowired
    FlightService flightService;

   @Autowired
    AccountService accountService;

   @PostMapping("/addflight")
    public ResponseEntity<Flight>  addFlight(@RequestBody Flight flight){
       Flight addedFlight = flightService.addFlight(flight);

       return new   ResponseEntity<Flight> (addedFlight, new HttpHeaders(), HttpStatus.OK);

   }

    @GetMapping("/getAllFlight")
    ResponseEntity<List<Flight>> getAllFlight(){
       List<Flight> allFlightList =flightService.getAllFlights();
       return new  ResponseEntity<List<Flight>>(allFlightList,new HttpHeaders(), HttpStatus.OK);}


    @PostMapping("/search")
    ResponseEntity<List<Flight>> searchFlights(@RequestBody FlightCriteria flightCriteria){
        List<Flight> allFlightList =flightService.searchFlight(flightCriteria).stream().toList();

        return new  ResponseEntity<List<Flight>>(allFlightList,new HttpHeaders(), HttpStatus.OK);
   }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<Flight>> getFlightById(@PathVariable("id") Long idFlight) {
        Optional<Flight> flight = flightService.getFlight(idFlight);
        return ResponseEntity.ok(flight);
    }

    @GetMapping("/numberOfFlight")
    public ResponseEntity<Long> getNumberOfFlight(@RequestBody SynthesisCriteria synthesisCriteria){
       Long nbFlight = flightService.getNumberFlight(synthesisCriteria);
       return new ResponseEntity<Long>(nbFlight,new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/synthesecompany")
    ResponseEntity<List<SyntheseCompanyDto>> getNbsFlightByCompany(@RequestBody SynthesisCriteria synthesisCriteria){
       List<SyntheseCompanyDto> syntheseCompanyDtos = flightService.getNbsFlightByCompany(synthesisCriteria);
       return  new ResponseEntity<List<SyntheseCompanyDto>>(syntheseCompanyDtos , new HttpHeaders(),HttpStatus.OK);

    }
    @PostMapping("/register")
    public ResponseEntity<Account> addAccount(@RequestBody AccountDto accountDto){

       Account account = accountService.addAccount(accountDto);
       return new ResponseEntity<Account>(account,new HttpHeaders(), HttpStatus.OK);

    }

}

