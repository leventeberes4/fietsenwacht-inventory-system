package com.fietsenwachtapp.demo.repositories;

import com.fietsenwachtapp.demo.entities.WarehouseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface WarehouseRepository extends MongoRepository<WarehouseEntity, UUID> {
}
