package com.fietsenwachtapp.demo.DTOs;

import com.fietsenwachtapp.demo.entities.InventoryItem;

import java.util.List;
import java.util.UUID;

public record WarehouseDTO(UUID id, String name, String address, List<InventoryItem> inventory) {
}
