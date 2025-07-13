package com.fietsenwachtapp.demo.repositories;

import com.fietsenwachtapp.demo.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepository extends MongoRepository<UserEntity, UUID> {
}
