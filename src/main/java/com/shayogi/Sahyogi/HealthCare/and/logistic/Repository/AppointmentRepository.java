package com.shayogi.Sahyogi.HealthCare.and.logistic.Repository;

import com.shayogi.Sahyogi.HealthCare.and.logistic.Entity.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
