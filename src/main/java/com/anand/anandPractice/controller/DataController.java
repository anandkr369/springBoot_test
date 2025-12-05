package com.anand.anandPractice.controller;

import com.anand.anandPractice.entity.DataEntryPogo;
import com.anand.anandPractice.service.DataService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class DataController {
    @Autowired
    private DataService dataService;

    @GetMapping("/all")
    public ResponseEntity<List<DataEntryPogo>> findAll(){
        try {
            List<DataEntryPogo> data = dataService.findAll();
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<DataEntryPogo> findById(@PathVariable ObjectId myId){
         try {
             DataEntryPogo dataEntryPogo = dataService.findById(myId);
             return new ResponseEntity<>(dataEntryPogo,HttpStatus.OK);
         }
         catch (Exception e){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveEntry(@RequestBody DataEntryPogo newEntry){
        try {
            dataService.save(newEntry);
            return new ResponseEntity<>("Data saved Successfully!!",HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{myId}")
    public ResponseEntity<String> deleteEntry(@PathVariable ObjectId myId){
        try {
            if(dataService.findById(myId) != null){
                dataService.deleteById(myId);
                return new ResponseEntity<>("Record with ID:" + myId + " " +"has been deleted Successfully!!", HttpStatus.OK);
            }
            return new ResponseEntity<>("ID not found, Kindly enter valid ID!!",HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
