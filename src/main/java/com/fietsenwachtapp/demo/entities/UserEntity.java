package com.fietsenwachtapp.demo.entities;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class UserEntity {
    @Id
    private String id;
   public String name;


    public UserEntity(){}
    public UserEntity(String name) {
        this.name = name;
    }
}
