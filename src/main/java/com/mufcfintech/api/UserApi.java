package com.mufcfintech.api;

import lombok.Data;

@Data
public class UserApi {

    private String id;

    private String name;

    private String surname;

    private String birthDate;

    private String country;

    private String city;

    private String fullAddress;

    private String password;

    private String token;

    private String referralCode;
}
