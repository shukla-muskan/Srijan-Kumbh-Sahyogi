package com.shayogi.Sahyogi.HealthCare.and.logistic.Controller;

import com.shayogi.Sahyogi.HealthCare.and.logistic.Entity.RentalItem;
import com.shayogi.Sahyogi.HealthCare.and.logistic.Repository.RentalItemRepository;
import com.shayogi.Sahyogi.HealthCare.and.logistic.Service.RentalItemService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rentItem")
public class RentalItemController {

    @Autowired
    private RentalItemService rentalItemService;

    @GetMapping("/get")
    public List<RentalItem> getAllItem(){
        return rentalItemService.getAllItem();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addItems(
            @RequestParam("itemName") String itemName,
            @RequestParam("itemCategory") String itemCategory,
            @RequestParam("itemPrice") int itemPrice,
            @RequestParam("itemLocation") String itemLocation,
            @RequestParam("itemDescription") String itemDescription,
            @RequestParam("itemImagePath") MultipartFile file) {

        System.out.println(itemName);

        try {
            // Check if item already exists
            RentalItem oldItem = rentalItemService.findByName(itemName);
            if (oldItem != null) {
                return new ResponseEntity<>("Item already exists", HttpStatus.BAD_REQUEST);
            }

            // Save file somewhere (example: /uploads)
            String uploadDir = "uploads/";
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);
            Files.createDirectories(filePath.getParent());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);




            // Create and save new item
            RentalItem item = new RentalItem();
            item.setItemName(itemName);
            item.setItemCategory(itemCategory);
            item.setItemprice(itemPrice);
            item.setItemLocation(itemLocation);
            item.setItemDescription(itemDescription);
            item.setItemImagePath(filePath.toString()); // Save path to DB

            rentalItemService.saveItem(item);

            return new ResponseEntity<>("Item saved", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to save item", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteById(@PathVariable Long myId){
        rentalItemService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
