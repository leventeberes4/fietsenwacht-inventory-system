package com.fietsenwachtapp.demo.entities;

import org.springframework.data.annotation.Id;

import java.util.UUID;


public record UserEntity (@Id UUID id, String name) {

}
