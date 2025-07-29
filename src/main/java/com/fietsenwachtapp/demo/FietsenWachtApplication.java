package com.fietsenwachtapp.demo;

import com.fietsenwachtapp.demo.repositories.JobRepository;
import com.fietsenwachtapp.demo.repositories.SKURepository;
import com.fietsenwachtapp.demo.repositories.UserRepository;
import com.fietsenwachtapp.demo.repositories.WarehouseRepository;
import com.fietsenwachtapp.demo.services.WarehouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FietsenWachtApplication implements CommandLineRunner {


    @Autowired
    private JobRepository workItemRepository;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SKURepository skuRepository;
    @Autowired
    private WorkItemFactory workItemFactory;
    @Autowired
    WarehouseRepository warehouseRepository;

    private static final Logger logger = LoggerFactory.getLogger(FietsenWachtApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(FietsenWachtApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }

}
