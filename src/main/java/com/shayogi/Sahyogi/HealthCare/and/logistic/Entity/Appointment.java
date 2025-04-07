package com.shayogi.Sahyogi.HealthCare.and.logistic.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Appointment")
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private Integer age;
    private String gender;
    private String contactNumber;
    private String address;


    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
}
