package com.fietsenwachtapp.demo.controllers;


import com.fietsenwachtapp.demo.DTOs.InventoryItemUpdateDTO;
import com.fietsenwachtapp.demo.DTOs.WarehouseCreateDTO;
import com.fietsenwachtapp.demo.DTOs.WarehouseDTO;
import com.fietsenwachtapp.demo.DTOs.WarehouseListDTO;
import com.fietsenwachtapp.demo.exceptions.SkuIdsDontExistException;
import com.fietsenwachtapp.demo.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController()
@RequestMapping("/services/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;


    @GetMapping("/list")
    public ResponseEntity<List<WarehouseListDTO>> getWarehouseList() {
        return ResponseEntity.ok(warehouseService.getWarehouseList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseDTO> getWarehouseById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(warehouseService.getWarehouseById(id));
    }


    @PostMapping("/add")
    public ResponseEntity<WarehouseDTO> addWarehouse(@RequestBody WarehouseCreateDTO warehouseCreateDTO) {
        return ResponseEntity.ok(warehouseService.addNewWarehouse(warehouseCreateDTO));
    }

    @PostMapping("inventory/{id}")
    public ResponseEntity<WarehouseDTO> updateInventory(@PathVariable("id") UUID id,
                                                        @RequestBody List<InventoryItemUpdateDTO> incomingItems) {
        var invalidIds = warehouseService.filterNonExistingIds(incomingItems);
        if (!invalidIds.isEmpty()) {
            throw new SkuIdsDontExistException(invalidIds);
        }
        ;
        return ResponseEntity.ok(warehouseService.updateWarehouseInventory(id, incomingItems));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<WarehouseDTO> updateSKU(
            @PathVariable("id") UUID id,
            @RequestBody WarehouseCreateDTO updatedWarehouse) {
        return ResponseEntity.ok(warehouseService.updateWarehouse(id, updatedWarehouse));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteSKU(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(warehouseService.deleteWarehouse(id));
    }
}
