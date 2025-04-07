package com.shayogi.Sahyogi.HealthCare.and.logistic.Controller;

import com.shayogi.Sahyogi.HealthCare.and.logistic.DTO.LoginRequest;
import com.shayogi.Sahyogi.HealthCare.and.logistic.DTO.SignupRequest;
import com.shayogi.Sahyogi.HealthCare.and.logistic.Entity.User;
import com.shayogi.Sahyogi.HealthCare.and.logistic.Repository.UserRepository;
import com.shayogi.Sahyogi.HealthCare.and.logistic.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            User user = authService.login(
                    request.getAadharNo(),
                    request.getPassword()

            );
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        Optional<User> existing = userRepository.findByAadharNo(request.getAadharNo());
        if (existing.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setAadharNo(request.getAadharNo());
        user.setMobileNumber(request.getMobileNo());
        user.setRole(request.getRole());
        user.setPassword(request.getPassword());

        userRepository.save(user);
        return ResponseEntity.ok("Signup successful");
    }

}
