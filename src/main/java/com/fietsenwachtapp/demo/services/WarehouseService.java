package com.fietsenwachtapp.demo.services;

import com.fietsenwachtapp.demo.DTOs.InventoryItemUpdateDTO;
import com.fietsenwachtapp.demo.DTOs.WarehouseCreateDTO;
import com.fietsenwachtapp.demo.DTOs.WarehouseDTO;
import com.fietsenwachtapp.demo.DTOs.WarehouseListDTO;
import com.fietsenwachtapp.demo.entities.InventoryItem;
import com.fietsenwachtapp.demo.entities.WarehouseEntity;
import com.fietsenwachtapp.demo.exceptions.ResourceNotFoundException;
import com.fietsenwachtapp.demo.mappers.WarehouseMapper;
import com.fietsenwachtapp.demo.repositories.SKURepository;
import com.fietsenwachtapp.demo.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WarehouseService extends InventoryService<WarehouseEntity, WarehouseRepository> {

    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    WarehouseMapper warehouseMapper;
    @Autowired
    SKURepository skuRepository;

    public WarehouseDTO addNewWarehouse(WarehouseCreateDTO warehouseCreateDTO) {
        List<InventoryItem> newInventoryList = new ArrayList<>() {
        };

        WarehouseEntity newWarehouse = new WarehouseEntity(warehouseCreateDTO.name(), newInventoryList, warehouseCreateDTO.address());
        return warehouseMapper.toDTO(warehouseRepository.insert(newWarehouse));
    }

    public List<WarehouseListDTO> getWarehouseList() {
        return warehouseRepository.findAll().stream().map(warehouseMapper::toListDTO).toList();
    }

    public WarehouseDTO getWarehouseById(UUID id) {
        WarehouseEntity existing = warehouseRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse not found: " + id));
        return warehouseMapper.toDTO(existing);
    }

    public Boolean deleteWarehouse(UUID warehouseId) {
        if (warehouseRepository.findById(warehouseId).isEmpty()) {
            return false;
        }
        warehouseRepository.deleteById(warehouseId);
        return true;
    }

    public WarehouseDTO updateWarehouse(UUID id, WarehouseCreateDTO updatedWarehouse) {
        WarehouseEntity existing = warehouseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found: " + id));

        warehouseMapper.updateEntityFromDto(updatedWarehouse, existing);

        WarehouseEntity saved = warehouseRepository.save(existing);
        return warehouseMapper.toDTO(saved);
    }

    public List<UUID> filterNonExistingIds(List<InventoryItemUpdateDTO> incomingItems) {
        List<UUID> invalidIds = new ArrayList<>();

        for (InventoryItemUpdateDTO item : incomingItems) {
            UUID skuId = item.itemID();

            boolean exists = skuRepository.existsById(skuId);

            if (!exists) {
                invalidIds.add(skuId);
            }
        }

        return invalidIds;
    }

    public WarehouseDTO updateWarehouseInventory(UUID id, List<InventoryItemUpdateDTO> incomingItems) {
        WarehouseEntity warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found"));

        for (InventoryItemUpdateDTO update : incomingItems) {
            UUID itemId = update.itemID();
            int delta = update.delta();

            Optional<InventoryItem> itemOpt = warehouse.getInventory().stream()
                    .filter(currentItem -> currentItem.getSkuId().equals(itemId))
                    .findFirst();

            if (itemOpt.isPresent()) {
                InventoryItem item = itemOpt.get();
                int newQuantity = item.getQuantity() + delta;
                if (newQuantity < 0) {
                    throw new IllegalArgumentException("Quantity cannot be negative for item: " + itemId);
                }
                item.setQuantity(newQuantity);
            } else {
                if (delta > 0) {
                    InventoryItem newItem = new InventoryItem(itemId, delta);
                    warehouse.addOrUpdateItem(newItem);
                } else {
                    throw new IllegalArgumentException("Cannot reduce quantity for non-existing item: " + itemId);
                }
            }
        }

        warehouse = warehouseRepository.save(warehouse);
        return warehouseMapper.toDTO(warehouse);
    }
}
