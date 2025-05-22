package com.example.FlightApplication.flight.flightRepository.impl;


import com.example.FlightApplication.flight.dto.SyntheseCompanyDto;
import com.example.FlightApplication.flight.enumerations.CompanyName;
import com.example.FlightApplication.flight.model.Flight;
import com.example.FlightApplication.flight.model.FlightCriteria;
import com.example.FlightApplication.flight.model.SynthesisCriteria;
import com.example.FlightApplication.flight.repository.FlightRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
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
        if(flightCriteria.getDepartureLocation() != null){
            predicates.add(cb.like(flight.get("departureLocation"),"%" + flightCriteria.getDepartureLocation() + "%"));
        }
        if(flightCriteria.getArrivalLocation() != null){
            predicates.add(cb.like(flight.get("arrivalLocation") , "%" + flightCriteria.getArrivalLocation()+ "%"));
        }
        if(flightCriteria.getFlightType() != null){
            predicates.add(cb.like(flight.get("aircraftType"), "%" + flightCriteria.getFlightType() + "%"));
        }

        if(flightCriteria.getDepartureDateMax() != null){
            predicates.add(cb.lessThanOrEqualTo(flight.get("departureDate") , flightCriteria.getDepartureDateMax()));
        }
        if(flightCriteria.getDepartureDateMin() != null){
            predicates.add(cb.greaterThanOrEqualTo(flight.get("departureDate"), flightCriteria.getDepartureDateMin()));
        }
        if(flightCriteria.getArrivalDateMax() != null){
            predicates.add(cb.lessThanOrEqualTo(flight.get("arrivalDate") , flightCriteria.getArrivalDateMax()));
        }
        if(flightCriteria.getArrivalDateMin() != null){
            predicates.add(cb.greaterThanOrEqualTo(flight.get("arrivalDate"), flightCriteria.getArrivalDateMin()));
        }
        if (flightCriteria.getDepartureTimeMax() != null){
            predicates.add(cb.lessThanOrEqualTo(flight.get("departureTime"), flightCriteria.getDepartureTimeMax()));
        }
        if (flightCriteria.getDepartureTimeMin() != null){
            predicates.add(cb.greaterThanOrEqualTo(flight.get("departureTime"), flightCriteria.getDepartureTimeMin()));
        }
        if(flightCriteria.getArrivalTimeMax() != null){
            predicates.add(cb.lessThanOrEqualTo(flight.get("arrivalTime"), flightCriteria.getArrivalTimeMax()));
        }
        if (flightCriteria.getArrivalTimeMin() != null){
            predicates.add(cb.greaterThanOrEqualTo(flight.get("arrivalTime"), flightCriteria.getArrivalTimeMin()));
        }
        if (flightCriteria.getBackDateMax() != null){
            predicates.add(cb.lessThanOrEqualTo(flight.get("backDate"),flightCriteria.getBackDateMax()));
        }
        if (flightCriteria.getBackDateMin() != null){
            predicates.add(cb.greaterThanOrEqualTo(flight.get("backDate"), flightCriteria.getBackDateMin()));
        }
        if(flightCriteria.getBackTimeMax() != null){
            predicates.add(cb.lessThanOrEqualTo(flight.get("backTime"),flightCriteria.getBackTimeMax()));
        }
        if(flightCriteria.getBackTimeMin() != null){
            predicates.add(cb.greaterThanOrEqualTo(flight.get("backTime"),flightCriteria.getBackTimeMin()));
        }
        if(flightCriteria.getConnectionDurationMax() != null){
            predicates.add(cb.lessThanOrEqualTo(flight.get("connectionDuration"),flightCriteria.getConnectionDurationMax()));
        }
        if (flightCriteria.getConnectionDurationMin() != null){
            predicates.add(cb.greaterThanOrEqualTo(flight.get("connectionDuration"),flightCriteria.getConnectionDurationMin()));
        }
        if (flightCriteria.getFlightDurationMax() != null){
            predicates.add(cb.lessThanOrEqualTo(flight.get("flightDuration"), flightCriteria.getFlightDurationMax()));
        }
        if(flightCriteria.getFlightDurationMin() != null ){
            predicates.add(cb.greaterThanOrEqualTo(flight.get("flightDuration"),flightCriteria.getFlightDurationMin()));
        }

        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Long getNumberFlight(SynthesisCriteria synthesisCriteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<Flight> flight = query.from(Flight.class);
        query.select(cb.count(flight));

        List<Predicate> predicates = new ArrayList<>();

        if(SynthesisCriteria.getDepartureDateMax() != null){
            predicates.add(cb.lessThanOrEqualTo(flight.get("departureDate") , SynthesisCriteria.getDepartureDateMax()));
        }
        if(SynthesisCriteria.getDepartureDateMin() != null){
            predicates.add(cb.greaterThanOrEqualTo(flight.get("departureDate"), SynthesisCriteria.getDepartureDateMin()));
        }
        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public List<SyntheseCompanyDto> getNbsFlightByCompany(SynthesisCriteria synthesisCriteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<SyntheseCompanyDto> query = cb.createQuery(SyntheseCompanyDto.class);
        Root<Flight> flight = query.from(Flight.class);
        Expression<CompanyName> groupByExp= flight.get("company").get("companyName").as(CompanyName.class);
        Expression<Long> countExp = cb.count(groupByExp);
        query.multiselect(groupByExp,countExp);
        query.groupBy(groupByExp);
        List<Predicate> predicates = new ArrayList<>();

        if(SynthesisCriteria.getDepartureDateMax() != null){
            predicates.add(cb.lessThanOrEqualTo(flight.get("departureDate") , SynthesisCriteria.getDepartureDateMax()));
        }
        if(SynthesisCriteria.getDepartureDateMin() != null){
            predicates.add(cb.greaterThanOrEqualTo(flight.get("departureDate"), SynthesisCriteria.getDepartureDateMin()));
        }
        query.where(predicates.toArray(new Predicate[0]));


        return entityManager.createQuery(query).getResultList();
    }
}
