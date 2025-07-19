package com.fietsenwachtapp.demo.repositories;

import com.fietsenwachtapp.demo.entities.InventoryHolder;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface IInventoryRepository<T extends InventoryHolder> extends MongoRepository<T, UUID> {
}
