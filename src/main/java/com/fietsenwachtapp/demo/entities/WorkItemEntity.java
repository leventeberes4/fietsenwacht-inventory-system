package com.fietsenwachtapp.demo.entities;

import com.fietsenwachtapp.demo.JobStatus;
import org.springframework.data.annotation.Id;

import java.util.List;

public class WorkItemEntity {
    @Id
    private String id;
    public Address jobAddress;
    Float durationSeconds;
    Float cost;
    public List<UserEntity> assignedMechanics;
    String customerName;
    String jobDescription;
    List<PartEntity> partsUsed;
    JobStatus jobStatus;

    public WorkItemEntity(){}


    public WorkItemEntity(String id, Address jobAddress, Float durationSeconds, Float cost, List<UserEntity> assignedMechanics, String customerName, String jobDescription, List<PartEntity> partsUsed, JobStatus jobStatus) {
        this.jobAddress = jobAddress;
        this.durationSeconds = durationSeconds;
        this.cost = cost;
        this.assignedMechanics = assignedMechanics;
        this.customerName = customerName;
        this.jobDescription = jobDescription;
        this.partsUsed = partsUsed;
        this.jobStatus = jobStatus;
    }

    public static class Address {
        public String zipCode;
        public String city;
        public String street;
    }
}
