package com.example.FlightApplication.flight.repository;

import com.example.FlightApplication.flight.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long>,FlightRepositoryCustom {
}
