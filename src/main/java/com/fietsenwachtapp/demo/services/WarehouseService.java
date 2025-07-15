package com.fietsenwachtapp.demo.services;

import com.fietsenwachtapp.demo.entities.InventoryItem;
import com.fietsenwachtapp.demo.entities.WarehouseEntity;
import com.fietsenwachtapp.demo.repositories.PartRepository;
import com.fietsenwachtapp.demo.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarehouseService {

    @Autowired
    WarehouseRepository warehouseRepository;
    PartRepository partRepositry;

       public void addNewWarehouse(String name, String address){
            warehouseRepository.deleteAll();

            List<InventoryItem> newInventoryList = new ArrayList<>();

            WarehouseEntity newWarehouse = new WarehouseEntity(name,newInventoryList,address);
            warehouseRepository.save(newWarehouse);
        }
}
