package com.shayogi.Sahyogi.HealthCare.and.logistic.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "RentalItem")
@Data
public class RentalItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String itemName;
    private String itemCategory;
    private int itemprice;
    private String itemImagePath;
    private String itemLocation;
    private String itemDescription;

}
