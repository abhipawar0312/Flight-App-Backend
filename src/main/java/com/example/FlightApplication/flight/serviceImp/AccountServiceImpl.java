package com.example.FlightApplication.flight.serviceImp;

import com.example.FlightApplication.flight.dto.AccountDto;
import com.example.FlightApplication.flight.model.Account;
import com.example.FlightApplication.flight.repository.AccountRepository;
import com.example.FlightApplication.flight.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public Account addAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setUsername(accountDto.getUsername());
        account.setPassword(accountDto.getPassword());
        account.setConfpassword(accountDto.getConfpassword());
        account.setEmail(accountDto.getEmail());

        return accountRepository.save(account);
    }
}
