package com.fietsenwachtapp.demo.controllers;

import com.fietsenwachtapp.demo.entities.WorkItemEntity;
import com.fietsenwachtapp.demo.repositories.WorkItemRepository;
import com.fietsenwachtapp.demo.services.JobService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/services")
public class WorkItemController {

   private final JobService jobService;

    public WorkItemController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/joblist/{id}")
    public ResponseEntity<List<WorkItemEntity>> getWorkListByUserId(@PathVariable("id") String id) {

        return jobService.getWorkListByUserId(id);
    }
}
