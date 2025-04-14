package com.shayogi.Sahyogi.HealthCare.and.logistic.RequestAndResponse;

import lombok.Data;

@Data
public class AuthResponse {
private String message;
private boolean status;
private String token;

}
