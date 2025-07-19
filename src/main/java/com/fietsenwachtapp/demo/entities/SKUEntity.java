package com.fietsenwachtapp.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.UUID;

@Document(collection = "skus")
public class SKUEntity {

    @Id
    private UUID id;
    private String name;
    private long priceInCents;

    // Constructor
    public SKUEntity(String name, long priceInCents) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.priceInCents = priceInCents;
    }

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(long priceInCents) {
        this.priceInCents = priceInCents;
    }
}