package com.example.FlightApplication.flight.service;

import com.example.FlightApplication.flight.dto.AccountDto;
import com.example.FlightApplication.flight.model.Account;

public interface AccountService {

    Account addAccount(AccountDto accountDto);
}
