package com.mufcfintech.api;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Data
@Jacksonized
public class UserPatchApi implements Serializable {

    private String name;

    private String surname;

    private String birthDate;

    private String country;

    private String city;

    private String fullAddress;

    private String password;
}
