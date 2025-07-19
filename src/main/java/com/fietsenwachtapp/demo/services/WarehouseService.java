package com.fietsenwachtapp.demo.services;

import com.fietsenwachtapp.demo.entities.InventoryItem;
import com.fietsenwachtapp.demo.entities.WarehouseEntity;
import com.fietsenwachtapp.demo.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WarehouseService extends InventoryService<WarehouseEntity,WarehouseRepository> {

    @Autowired
    WarehouseRepository warehouseRepository;

       public WarehouseEntity addNewWarehouse(String name, String address){
           List<InventoryItem> newInventoryList = new ArrayList<>() {
           };

           WarehouseEntity newWarehouse = new WarehouseEntity(UUID.randomUUID(),name,newInventoryList,address);
           return warehouseRepository.insert(newWarehouse);
       }
}
