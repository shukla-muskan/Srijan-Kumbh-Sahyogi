package com.shayogi.Sahyogi.HealthCare.and.logistic.Service;

import com.shayogi.Sahyogi.HealthCare.and.logistic.Entity.User;
import com.shayogi.Sahyogi.HealthCare.and.logistic.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public User login(String aadharNo, String password) {
        return userRepository.findByAadharNoAndPassword(aadharNo, password)
                .orElseThrow(() -> new RuntimeException("Invalid credentials or role"));
    }

    public User signup(String name, String aadharNo, String mobile,  String password) {
        if (userRepository.findByNameAndAadharNoAndMobileNumberAndPassword(name, aadharNo, mobile,password).isPresent()) {
            throw new RuntimeException("User already exists with same credentials");
        }

        User user = new User(name, aadharNo, mobile,password);
        return userRepository.save(user);
    }


}
