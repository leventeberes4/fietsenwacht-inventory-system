package com.fietsenwachtapp.demo.entities;

import java.util.List;

public class ServiceVanEntity extends InventoryHolder {
    String licensePlate;

    public ServiceVanEntity() {
    }

    public ServiceVanEntity( String name, List<InventoryItem> inventory, String licensePlate) {
        super(name, inventory);
        this.licensePlate = licensePlate;
    }
}
