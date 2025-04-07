package com.shayogi.Sahyogi.HealthCare.and.logistic.Service;

import com.shayogi.Sahyogi.HealthCare.and.logistic.Entity.RentalItem;
import com.shayogi.Sahyogi.HealthCare.and.logistic.Repository.RentalItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RentalItemService {

    @Autowired
    private RentalItemRepository rentalItemRepository;

    public void saveItem(RentalItem item){
        rentalItemRepository.save(item);
    }

    public List<RentalItem> getAllItem(){
        return rentalItemRepository.findAll();
    }

    public RentalItem findByName(String name){
        return rentalItemRepository.findByItemName(name);
    }

    public void deleteById(Long id){
        rentalItemRepository.deleteById(id);
    }

}
