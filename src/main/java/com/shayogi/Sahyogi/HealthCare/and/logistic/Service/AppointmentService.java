package com.shayogi.Sahyogi.HealthCare.and.logistic.Service;

import com.shayogi.Sahyogi.HealthCare.and.logistic.Entity.Appointment;
import com.shayogi.Sahyogi.HealthCare.and.logistic.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
