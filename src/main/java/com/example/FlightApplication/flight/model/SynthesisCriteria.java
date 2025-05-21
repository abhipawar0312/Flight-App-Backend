package com.example.FlightApplication.flight.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SynthesisCriteria {
    private LocalDate departureDateMin;
    private LocalDate departureDateMax;

    public static LocalDate getDepartureDateMin() {
        return departureDateMin;
    }

    public static LocalDate getDepartureDateMax() {
        return departureDateMax;
    }
}
