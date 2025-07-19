package com.fietsenwachtapp.demo;

import com.fietsenwachtapp.demo.entities.SKUEntity;
import com.fietsenwachtapp.demo.entities.UserEntity;
import com.fietsenwachtapp.demo.entities.JobItemEntity;
import com.fietsenwachtapp.demo.repositories.SKURepository;
import com.fietsenwachtapp.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class WorkItemFactory {
    public static JobItemEntity createMockWorkItem(UserRepository userRepository, SKURepository partRepositry) {
        // Mock address
        JobItemEntity.Address address = new JobItemEntity.Address();
        address.city = "MockCity";
        address.street = "123 Mock Street";
        address.zipCode = "12345";

        userRepository.deleteAll();
        partRepositry.deleteAll();
        // Mock mechanics
        UserEntity mech1 = userRepository.insert(new UserEntity(UUID.randomUUID(),"John Doe"));
        UserEntity mech2 = userRepository.insert(new UserEntity( UUID.randomUUID(),"Jane Smith"));

        // Mock parts

        // Create and return mock WorkItemEntity
        return new JobItemEntity(
                UUID.randomUUID().toString(),
                address,
                3600.0f, // 1 hour
                150.0f,
                Arrays.asList(mech1, mech2),
                "Alice Johnson",
                "Brake replacement and oil change",
                List.of(new SKUEntity("asd",1),new SKUEntity("asd",1)),
                JobStatus.INPROGRESS
        );
    }
}
