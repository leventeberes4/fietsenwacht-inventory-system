package com.fietsenwachtapp.demo.services;

import com.fietsenwachtapp.demo.entities.InventoryHolder;
import com.fietsenwachtapp.demo.entities.InventoryItem;
import com.fietsenwachtapp.demo.repositories.IInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.UUID;

@Service
public abstract class InventoryService<P extends InventoryHolder, T extends IInventoryRepository<P>> {
    @Autowired
    T inventoryRepository;

    @Transactional
    public void addItemsToInventory(UUID uuid, InventoryItem... items) {
        inventoryRepository.findById(uuid).ifPresent(inventory -> {
            Arrays.stream(items)
                    .forEach(inventory::addOrUpdateItem);

            inventoryRepository.save(inventory);
        });
    }
}
