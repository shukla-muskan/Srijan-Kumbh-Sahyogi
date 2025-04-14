//package com.shayogi.Sahyogi.HealthCare.and.logistic.Service;
//
//
//
//
//import com.shayogi.Sahyogi.HealthCare.and.logistic.Entity.Doctor;
//import com.shayogi.Sahyogi.HealthCare.and.logistic.Repository.DoctorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class DoctorService {
//    @Autowired
//    private DoctorRepository doctorRepository;
//
//    public Doctor getDoctorById(Long id) {
//        return doctorRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
//    }
//
//
//
//
//    public List<Doctor> getAllDoctors() {
//        return doctorRepository.findAll();
//    }
//
//
//
//    public Doctor saveDoctor(Doctor doctor) {
//        return doctorRepository.save(doctor);
//    }
//
//
//    public void deleteDoctor(Long id) {
//        doctorRepository.deleteById(id);
//    }
//
//}