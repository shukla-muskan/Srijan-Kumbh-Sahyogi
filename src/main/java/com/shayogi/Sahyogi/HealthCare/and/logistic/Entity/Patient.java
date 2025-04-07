package com.shayogi.Sahyogi.HealthCare.and.logistic.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Patient")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

   // @Pattern(regexp = "\\d{12}", message = "Aadhar must be exactly 12 digits")
  //  @Column(nullable = false, unique = true, length = 12)
  //  private String aadhar;

    private int age;

    private String gender;

    private String disease;

    @Column(length = 10)
    private String contact;

    private String address;

   // private String prescriptionImagePath;

    private boolean verified = false;

    private LocalDate dateAdded = LocalDate.now();
}
