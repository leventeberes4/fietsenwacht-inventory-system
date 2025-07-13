package com.fietsenwachtapp.demo.repositories;

import com.fietsenwachtapp.demo.entities.PartEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PartRepositry extends MongoRepository<PartEntity, UUID> {
}
