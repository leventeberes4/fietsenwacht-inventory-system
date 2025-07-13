package com.fietsenwachtapp.demo;

import com.fietsenwachtapp.demo.entities.WorkItemEntity;
import com.fietsenwachtapp.demo.repositories.PartRepositry;
import com.fietsenwachtapp.demo.repositories.UserRepository;
import com.fietsenwachtapp.demo.repositories.WorkItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private WorkItemRepository workItemRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PartRepositry partRepositry;
	@Autowired
	private WorkItemFactory workItemFactory;

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		workItemRepository.deleteAll();
				// save a couple of customers
		WorkItemEntity save = workItemRepository.save(workItemFactory.createMockWorkItem(userRepository, partRepositry));
	}

}
