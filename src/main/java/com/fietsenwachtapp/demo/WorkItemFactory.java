package com.fietsenwachtapp.demo;

import com.fietsenwachtapp.demo.entities.PartEntity;
import com.fietsenwachtapp.demo.entities.UserEntity;
import com.fietsenwachtapp.demo.entities.WorkItemEntity;
import com.fietsenwachtapp.demo.repositories.PartRepositry;
import com.fietsenwachtapp.demo.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;

@Service
public class WorkItemFactory {
    public static WorkItemEntity createMockWorkItem(UserRepository userRepository,PartRepositry partRepositry) {
        // Mock address
        WorkItemEntity.Address address = new WorkItemEntity.Address();
        address.city = "MockCity";
        address.street = "123 Mock Street";
        address.zipCode = "12345";

        userRepository.deleteAll();
        partRepositry.deleteAll();
        // Mock mechanics
        UserEntity mech1 = userRepository.save(new UserEntity("John Doe"));
        UserEntity mech2 = userRepository.save(new UserEntity( "Jane Smith"));

        // Mock parts
        PartEntity part1 = partRepositry.save(new PartEntity("Brake Pad"));
        PartEntity part2 =   partRepositry.save( new PartEntity("Oil Filter"));

        // Create and return mock WorkItemEntity
        return new WorkItemEntity(
                UUID.randomUUID().toString(),
                address,
                3600.0f, // 1 hour
                150.0f,
                Arrays.asList(mech1, mech2),
                "Alice Johnson",
                "Brake replacement and oil change",
                Arrays.asList(part1, part2),
                JobStatus.INPROGRESS
        );
    }
}
