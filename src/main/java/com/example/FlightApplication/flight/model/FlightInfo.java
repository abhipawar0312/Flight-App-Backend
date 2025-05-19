package com.example.FlightApplication.flight.model;


import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class FlightInfo {

    private String title;
    private String description;

}

