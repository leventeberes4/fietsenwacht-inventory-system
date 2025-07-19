package com.fietsenwachtapp.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document
public abstract class InventoryHolder {
    @Id
    public UUID id;
    protected String name;
    private List<InventoryItem> inventory = new ArrayList<>();


    public InventoryHolder(UUID id, String name, List<InventoryItem>  inventory) {
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

    // TODO: Potentially use HashMap for more performance
    public void addOrUpdateItem(InventoryItem item) {
        for (InventoryItem i : inventory) {
            if (i.getSKU_ID().equals(item.getSKU_ID())) {
                i.setQuantity(i.getQuantity() + item.getQuantity());
                return;
            }
        }
        inventory.add(item);
    }

    public InventoryItem getItem(UUID skuId) {
        return inventory.stream()
                .filter(i -> i.getSKU_ID().equals(skuId))
                .findFirst()
                .orElse(null);
    }

}
