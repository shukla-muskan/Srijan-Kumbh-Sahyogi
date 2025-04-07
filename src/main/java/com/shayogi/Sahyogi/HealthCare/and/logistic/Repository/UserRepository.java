package com.shayogi.Sahyogi.HealthCare.and.logistic.Repository;


import com.shayogi.Sahyogi.HealthCare.and.logistic.Entity.Role;
import com.shayogi.Sahyogi.HealthCare.and.logistic.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNameAndAadharNoAndMobileNumberAndRoleAndPassword(String name, String aadhar, String mobile, Role role, String password);
    Optional<User> findByAadharNo(String aadhar);
    //Optional<User> findByMobileNumber(String mobile);
    Optional<User> findByAadharNoAndPassword(String aadhar, String password);
}


