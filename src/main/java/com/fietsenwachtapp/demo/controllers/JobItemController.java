package com.fietsenwachtapp.demo.controllers;

import com.fietsenwachtapp.demo.entities.JobItemEntity;
import com.fietsenwachtapp.demo.services.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/services/joblist")
public class JobItemController {

   private final JobService jobService;

    public JobItemController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<JobItemEntity>> getWorkListByUserId(@PathVariable("id") String id) {

        return jobService.getWorkListByUserId(id);
    }
}
