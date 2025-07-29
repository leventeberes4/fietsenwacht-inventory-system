package com.fietsenwachtapp.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document
public abstract class InventoryHolder {
    @Id
    public UUID id;
    protected String name;

    private List<InventoryItem> inventory = new ArrayList<>();


    public InventoryHolder(UUID id, String name, List<InventoryItem> inventory) {
        this.id = id;
        this.name = name;
        this.inventory = inventory;

    }

    protected InventoryHolder() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // TODO: Potentially use HashMap for more performance
    public void addOrUpdateItem(InventoryItem item) {
        for (InventoryItem i : inventory) {
            if (i.getSkuId().equals(item.getSkuId())) {
                i.setQuantity(i.getQuantity() + item.getQuantity());
                return;
            }
        }
        inventory.add(item);
    }

    public void setInventory(List<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    public List<InventoryItem> getInventory() {
        return inventory;
    }

    public InventoryItem getItem(UUID skuId) {
        return inventory.stream()
                .filter(i -> i.getSkuId().equals(skuId))
                .findFirst()
                .orElse(null);
    }

}
