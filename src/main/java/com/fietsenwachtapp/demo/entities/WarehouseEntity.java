package com.fietsenwachtapp.demo.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Document("warehouses")
public class WarehouseEntity extends InventoryHolder {
    String address;

    public WarehouseEntity(UUID id, String name, List<InventoryItem> inventory, String address) {
        super(id,name, inventory);
        this.address = address;
    }
    public WarehouseEntity(){}
}
