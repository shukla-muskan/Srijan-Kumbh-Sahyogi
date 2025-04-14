package com.shayogi.Sahyogi.HealthCare.and.logistic.DTO;


import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentRequestDTO {
    private String fullName;
    private Integer age;
    private String gender;
    private String contactNumber;
    private String address;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private Long doctorId;
}