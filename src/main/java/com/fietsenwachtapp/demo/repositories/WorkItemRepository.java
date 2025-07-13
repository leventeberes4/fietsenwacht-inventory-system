package com.fietsenwachtapp.demo.repositories;

import com.fietsenwachtapp.demo.entities.WorkItemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface WorkItemRepository extends MongoRepository<WorkItemEntity, String> {

    @Query("{'assignedMechanics.id': ?0 }")
     List<WorkItemEntity> findWorkListByUserId(String id);
}
