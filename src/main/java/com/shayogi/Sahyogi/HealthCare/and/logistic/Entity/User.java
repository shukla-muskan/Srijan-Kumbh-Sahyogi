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

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(unique = true, nullable = false)
    private String password;

    public User() {}

    public User(String name, String aadharNo, String mobileNumber, String password, Role role) {
        this.name = name;
        this.aadharNo = aadharNo;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.role = role;
    }
}
