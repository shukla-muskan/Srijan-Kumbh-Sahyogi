//package com.shayogi.Sahyogi.HealthCare.and.logistic.Controller;
//
//import com.shayogi.Sahyogi.HealthCare.and.logistic.Entity.Doctor;
//import com.shayogi.Sahyogi.HealthCare.and.logistic.Service.DoctorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping("/doctor")
//public class DoctorController {
//
//    @Autowired
//    private DoctorService doctorService;
//
//    // Get all doctors
//    @GetMapping("/get")
//    public List<Doctor> getAllDoctors() {
//        return doctorService.getAllDoctors();
//    }
//
//    // Get doctor by ID
//    @GetMapping("/get/{id}")
//    public ResponseEntity<?> getDoctorById(@PathVariable Long id) {
//        Doctor doctor = doctorService.getDoctorById(id);
//        if (doctor != null) {
//            return ResponseEntity.ok(doctor);
//        } else {
//            return ResponseEntity.status(404).body("Doctor not found");
//        }
//    }
//
//    // Add new doctor
//    @PostMapping("/add")
//    public ResponseEntity<?> addDoctor(@RequestBody Doctor doctor) {
//        Doctor savedDoctor = doctorService.saveDoctor(doctor);
//        return ResponseEntity.ok(savedDoctor);
//    }
//
//    // Delete doctor by ID
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteDoctor(@PathVariable Long id) {
//        doctorService.deleteDoctor(id);
//        return ResponseEntity.noContent().build();
//    }
//}
