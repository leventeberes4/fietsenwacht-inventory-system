package com.fietsenwachtapp.demo.services;

import com.fietsenwachtapp.demo.entities.JobItemEntity;
import com.fietsenwachtapp.demo.repositories.JobRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    private final JobRepository repository;

    public JobService(JobRepository repository) {
        this.repository = repository;
    }

   public ResponseEntity<List<JobItemEntity>> getWorkListByUserId(String id) {
            return ResponseEntity.ok(repository.findJobListByUserId(id).stream().toList());
    }
}
