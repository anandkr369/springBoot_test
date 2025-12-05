package com.anand.anandPractice.repository;

import com.anand.anandPractice.entity.DataEntryPogo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataRepo extends MongoRepository<DataEntryPogo, ObjectId> {
}
