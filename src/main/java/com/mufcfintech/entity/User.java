package com.mufcfintech.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {

    @Id
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
