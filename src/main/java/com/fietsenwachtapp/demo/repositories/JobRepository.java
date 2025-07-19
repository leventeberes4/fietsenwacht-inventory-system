package com.fietsenwachtapp.demo.repositories;

import com.fietsenwachtapp.demo.entities.JobItemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface JobRepository extends MongoRepository<JobItemEntity, String> {

    @Query("{'assignedMechanics.id': ?0 }")
     List<JobItemEntity> findJobListByUserId(String id);
}
