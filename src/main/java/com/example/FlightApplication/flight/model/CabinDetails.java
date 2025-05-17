package com.example.FlightApplication.flight.model;

import com.example.FlightApplication.flight.enumerations.CabinClass;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;


@Embeddable
@Data
public class CabinDetails {

    @Column(name = "cabin_class")
    @Enumerated(EnumType.STRING)
    private CabinClass cabinClass;

    private String baggage;
    private String cancellation;
    private String rebooking;
    private String refund;
    private double fare;
}
