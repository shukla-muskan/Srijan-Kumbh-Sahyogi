package com.shayogi.Sahyogi.HealthCare.and.logistic.DTO;

import lombok.Data;



@Data
public class SignupRequest {
    private String name;
    private String aadharNo;
    private String mobileNumber;
    private String password;
    public SignupRequest() {}
}

