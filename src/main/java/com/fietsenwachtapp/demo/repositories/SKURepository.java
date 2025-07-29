package com.fietsenwachtapp.demo.repositories;

import com.fietsenwachtapp.demo.entities.SKUEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SKURepository extends MongoRepository<SKUEntity, UUID> {

    List<SKUEntity> findAllByName(String name);

    Optional<SKUEntity> findByName(String name);

    Optional<SKUEntity> findBySkuCode(String skuCode);
}
