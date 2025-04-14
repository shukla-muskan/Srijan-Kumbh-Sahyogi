package com.shayogi.Sahyogi.HealthCare.and.logistic.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String aadharNo;

    @Column
    private String mobileNumber;


    @Column( nullable = false)
    private String password;

    public User() {}

    public User(String name, String aadharNo, String mobileNumber, String password) {
        this.name = name;
        this.aadharNo = aadharNo;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }
}
