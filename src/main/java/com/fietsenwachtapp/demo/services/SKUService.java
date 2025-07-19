package com.fietsenwachtapp.demo.services;


import com.fietsenwachtapp.demo.DTOs.SkuCreateDTO;
import com.fietsenwachtapp.demo.DTOs.SkuDTO;
import com.fietsenwachtapp.demo.entities.SKUEntity;
import com.fietsenwachtapp.demo.mappers.SkuMapper;
import com.fietsenwachtapp.demo.repositories.SKURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SKUService {

    @Autowired
    SKURepository skuRepository;

    @Autowired
    SkuMapper skuMapper;

    public List<SkuDTO> getSKUList(){
        return skuRepository.findAll().stream().map(skuMapper::toDTO).toList();
    }


    public SkuDTO addSKU(SkuCreateDTO skuToAdd){
        if (skuToAdd.name() == null || skuToAdd.name().isBlank()) {
            throw new IllegalArgumentException("SKU name cannot be empty.");
        }
        if (skuToAdd.priceInCents() < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        if (skuRepository.findAllByName(skuToAdd.name()).isEmpty()) {
            SKUEntity entity = skuMapper.toSKUEntity(skuToAdd);
            SKUEntity saved = skuRepository.save(entity);
            return skuMapper.toDTO(saved);
        } else {
            throw new IllegalArgumentException("SKU with this name already exists: " +skuToAdd.name());
        }

    }

}
