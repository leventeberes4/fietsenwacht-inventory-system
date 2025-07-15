package com.fietsenwachtapp.demo.entities;

import org.springframework.data.annotation.Id;

import java.util.List;

public abstract class InventoryHolder {
    @Id
    private String id;
    protected String name;
    protected List<InventoryItem> inventory;


    public InventoryHolder( String name, List<InventoryItem> inventory) {
        this.name = name;
        this.inventory = inventory;
    }

    protected InventoryHolder() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<InventoryItem> getInventory() {
        return inventory;
    }
}
