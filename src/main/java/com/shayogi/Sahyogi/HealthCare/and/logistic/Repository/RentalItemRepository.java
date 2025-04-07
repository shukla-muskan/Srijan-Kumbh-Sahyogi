package com.shayogi.Sahyogi.HealthCare.and.logistic.Repository;

import com.shayogi.Sahyogi.HealthCare.and.logistic.Entity.RentalItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalItemRepository extends JpaRepository<RentalItem,Long> {
    RentalItem findByItemName(String Name);
}
