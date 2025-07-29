package com.fietsenwachtapp.demo.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document("warehouses")
public class WarehouseEntity extends InventoryHolder {

    String address;

    public WarehouseEntity(String name, List<InventoryItem> inventory, String address) {
        super(UUID.randomUUID(), name, inventory);
        this.address = address;
    }

    public WarehouseEntity() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
