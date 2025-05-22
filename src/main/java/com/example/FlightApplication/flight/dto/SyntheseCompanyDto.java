package com.example.FlightApplication.flight.dto;

import com.example.FlightApplication.flight.enumerations.CompanyName;
import lombok.Data;

@Data
public class SyntheseCompanyDto {
    private CompanyName companyName;
    private Long nbFlight;

}
