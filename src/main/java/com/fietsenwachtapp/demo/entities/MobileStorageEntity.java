package com.fietsenwachtapp.demo.entities;

import java.util.List;
import java.util.UUID;

public class MobileStorageEntity extends InventoryHolder {
    String licensePlate;

    public MobileStorageEntity() {
    }

    public MobileStorageEntity(UUID id, String name, List<InventoryItem> inventory, String licensePlate) {
        super(id,name, inventory);
        this.licensePlate = licensePlate;
    }
}
