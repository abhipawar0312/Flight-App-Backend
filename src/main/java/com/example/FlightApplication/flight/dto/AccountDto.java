package com.example.FlightApplication.flight.dto;

import lombok.Data;

@Data
public class AccountDto {

    private String username;
    private String password;
    private String confpassword;
    private String email;

    public AccountDto(){

    }

}
