package com.shayogi.Sahyogi.HealthCare.and.logistic.Repository;

import com.shayogi.Sahyogi.HealthCare.and.logistic.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByVerified(boolean verified);

}
