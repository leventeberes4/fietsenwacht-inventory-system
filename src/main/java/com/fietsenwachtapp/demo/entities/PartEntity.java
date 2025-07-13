package com.fietsenwachtapp.demo.entities;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class PartEntity {
    @Id
    private String id;
    String name;
    public PartEntity(){}
    public PartEntity(String name) {
        this.name = name;
    }
}
