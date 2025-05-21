package com.example.FlightApplication.flight.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SynthesisCriteria {
    private static LocalDate departureDateMin;
    private static LocalDate departureDateMax;

    public static LocalDate getDepartureDateMin() {
        return departureDateMin;
    }

    public static LocalDate getDepartureDateMax() {
        return departureDateMax;
    }
}
