package com.fietsenwachtapp.demo.DTOs;


import java.util.UUID;

public record InventoryItemUpdateDTO(UUID itemID, int delta) {
}
