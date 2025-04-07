package com.shayogi.Sahyogi.HealthCare.and.logistic.DTO;

import com.shayogi.Sahyogi.HealthCare.and.logistic.Entity.Role;
import lombok.Data;



@Data
public class SignupRequest {
    private String name;
    private String aadharNo;
    private String mobileNo;
    private Role role; // USER, SHG_MEMBER, ADMIN
    private String password;
    public SignupRequest() {}
}

