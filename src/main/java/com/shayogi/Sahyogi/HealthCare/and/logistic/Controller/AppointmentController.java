package com.shayogi.Sahyogi.HealthCare.and.logistic.Controller;

import com.shayogi.Sahyogi.HealthCare.and.logistic.Entity.Appointment;
import com.shayogi.Sahyogi.HealthCare.and.logistic.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
    }
}
