package com.anand.anandPractice.service;

import com.anand.anandPractice.entity.DataEntryPogo;
import com.anand.anandPractice.repository.DataRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataService {
    @Autowired
    private DataRepo dataRepo;

    public List<DataEntryPogo> findAll(){
        return dataRepo.findAll();
    }

    public DataEntryPogo findById(ObjectId id){
        return dataRepo.findById(id).orElse(null);
    }

    public DataEntryPogo save(DataEntryPogo newEntry){
        dataRepo.save(newEntry);
        return newEntry;
    }

    public  String deleteById(ObjectId id){
        dataRepo.deleteById(id);
        return "Deleted Successfully!!";
    }
}
