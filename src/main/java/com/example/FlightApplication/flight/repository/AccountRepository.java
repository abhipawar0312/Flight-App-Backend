package com.example.FlightApplication.flight.repository;

import com.example.FlightApplication.flight.model.Account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {
}
