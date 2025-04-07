package com.shayogi.Sahyogi.HealthCare.and.logistic.Controller;

import com.shayogi.Sahyogi.HealthCare.and.logistic.Entity.Patient;
import com.shayogi.Sahyogi.HealthCare.and.logistic.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    private final String uploadDir = "uploads/";

    @PostMapping
    public ResponseEntity<?> registerPatient(@RequestBody Patient patient) throws IOException {
        System.out.println(patient.getName());
        System.out.println(patient.getDisease());
        patient.setDateAdded(LocalDate.now());
        patient.setVerified(false);

        patientRepository.save(patient);

        return ResponseEntity.ok("Patient submitted successfully.");
    }

    @PutMapping("/{id}/verify")
    public ResponseEntity<?> verifyPatient(@PathVariable Long id) {
        System.out.println("Hiii");
        Optional<Patient> optional = patientRepository.findById(id);
        if (optional.isPresent()) {
            Patient patient = optional.get();
            patient.setVerified(true);
            patientRepository.save(patient);
            return ResponseEntity.ok("Patient verified.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient(
            @PathVariable Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String aadhar,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String disease,
            @RequestParam(required = false) String contact,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) MultipartFile prescriptionImage
    ) throws IOException {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }

        Patient patient = optionalPatient.get();

        if (name != null && name != patient.getName()) patient.setName(name);
       // if (aadhar != null && aadhar!= patient.getAadhar()) patient.setAadhar(aadhar);
        if (age != null) patient.setAge(age);
        if (gender != null) patient.setGender(gender);
        if (disease != null) patient.setDisease(disease);
        if (contact != null) patient.setContact(contact);
        if (address != null) patient.setAddress(address);

        // Optional: Update prescription image
//        if (prescriptionImage != null && !prescriptionImage.isEmpty()) {
//            String fileName = UUID.randomUUID() + "_" + prescriptionImage.getOriginalFilename();
//          //  Path filePath = Paths.get(uploadDir + fileName);
//         //   Files.createDirectories(filePath.getParent());
//           // Files.copy(prescriptionImage.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//          //  patient.setPrescriptionImagePath(filePath.toString());
//        }

        patientRepository.save(patient);
        return ResponseEntity.ok("Patient updated successfully");
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        System.out.println("Hello");
        return patientRepository.findAll();
    }

    @GetMapping("/unverified")
    public List<Patient> getUnverifiedPatients() {
        return patientRepository.findByVerified(false);
    }

    @GetMapping("/verified")
    public List<Patient> getVerifiedPatients() {
        return patientRepository.findByVerified(true);
    }

}
