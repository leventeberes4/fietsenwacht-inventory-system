package com.fietsenwachtapp.demo.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document("warehouses")
public class WarehouseEntity extends InventoryHolder {
    String address;

    public WarehouseEntity(String name, List<InventoryItem> inventory, String address) {
        super(name, inventory);
        this.address = address;
    }
    public WarehouseEntity(){}
}
