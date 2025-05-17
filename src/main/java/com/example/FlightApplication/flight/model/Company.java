package com.example.FlightApplication.flight.model;

import com.example.FlightApplication.flight.enumerations.CompanyName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int companyId;

    @JsonManagedReference
    @Column(name = "company_name")
    @Enumerated(EnumType.STRING)
    private CompanyName companyName;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<Flight> flights;

    @ElementCollection
    @CollectionTable(name = "cabin_details", joinColumns = @JoinColumn(name = "company_id"))
    private Set<CabinDetails> cabinDetails;

    @ElementCollection
    @CollectionTable(name = "flight_info", joinColumns = @JoinColumn(name = "company_id"))
    private Set<FlightInfo> flightInfo;


}
