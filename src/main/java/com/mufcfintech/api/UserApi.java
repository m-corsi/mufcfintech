package com.mufcfintech.api;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Data
@Jacksonized
public class UserApi extends UserPatchApi implements Serializable {

    private String id;

    private String token;

    private String referralCode;
}
