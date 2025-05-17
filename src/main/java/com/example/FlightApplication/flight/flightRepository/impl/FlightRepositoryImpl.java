package com.example.FlightApplication.flight.flightRepository.impl;


import com.example.FlightApplication.flight.model.Flight;
import com.example.FlightApplication.flight.model.FlightCriteria;
import com.example.FlightApplication.flight.repository.FlightRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class FlightRepositoryImpl implements FlightRepositoryCustom {

    private final EntityManager entityManager;

    public FlightRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Flight> searchFlights(FlightCriteria flightCriteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flight> query = cb.createQuery(Flight.class);
        Root<Flight> flight = query.from(Flight.class);

        List<Predicate> predicates = new ArrayList<>();

        if (flightCriteria.getCompany() != null) {
            predicates.add(cb.equal(flight.get("company"), flightCriteria.getCompany()));
        }
        if (flightCriteria.getFlightType() != null) {
            predicates.add(cb.equal(flight.get("flightType"), flightCriteria.getFlightType()));
        }
        if (flightCriteria.getTravelType() != null) {
            predicates.add(cb.equal(flight.get("travelType"), flightCriteria.getTravelType()));
        }

        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }
}
