package com.fietsenwachtapp.demo.controllers;

import com.fietsenwachtapp.demo.entities.WorkItemEntity;
import com.fietsenwachtapp.demo.repositories.WorkItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkItemController {

    private final WorkItemRepository repository;


    public WorkItemController(WorkItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/worklist/{id}")
    public ResponseEntity<List<WorkItemEntity>> getWorkListByUserId(@PathVariable("id") String id) {

        return ResponseEntity.ok(repository.findWorkListByUserId(id).stream().toList());
    }
}
