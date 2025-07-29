package com.fietsenwachtapp.demo.services;


import com.fietsenwachtapp.demo.DTOs.SkuCreateDTO;
import com.fietsenwachtapp.demo.DTOs.SkuDTO;
import com.fietsenwachtapp.demo.entities.SKUEntity;
import com.fietsenwachtapp.demo.mappers.SkuMapper;
import com.fietsenwachtapp.demo.repositories.SKURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SKUService {

    @Autowired
    SKURepository skuRepository;

    @Autowired
    SkuMapper skuMapper;

    public List<SkuDTO> getSKUList() {
        return skuRepository.findAll().stream().map(skuMapper::toDTO).toList();
    }

    private void validateSKU(SkuCreateDTO skuToAdd) {
        if (skuToAdd.name() == null || skuToAdd.name().isBlank()) {
            throw new IllegalArgumentException("SKU name cannot be empty.");
        }
        if (skuToAdd.skuCode() == null || skuToAdd.skuCode().isBlank()) {
            throw new IllegalArgumentException("SKU code cannot be empty.");
        }
        if (skuRepository.findBySkuCode(skuToAdd.skuCode()).isPresent()) {
            throw new IllegalArgumentException("SKU with this code already exists: " + skuToAdd.skuCode());
        }
        if (skuRepository.findByName(skuToAdd.name()).isPresent()) {
            throw new IllegalArgumentException("SKU with this name already exists: " + skuToAdd.name());
        }
    }

    public SkuDTO addSKU(SkuCreateDTO skuToAdd) {
        validateSKU(skuToAdd);
        SKUEntity entity = skuMapper.toSKUEntity(skuToAdd);
        SKUEntity saved = skuRepository.save(entity);
        return skuMapper.toDTO(saved);
    }

    public boolean deleteSKU(UUID skuId) {
        if (skuRepository.findById(skuId).isEmpty()) {
            return false;
        }
        skuRepository.deleteById(skuId);
        return true;
    }

    public SkuDTO updateSKU(UUID skuId, SkuCreateDTO updatedSku) {
        SKUEntity existing = skuRepository.findById(skuId)
                .orElseThrow(() -> new RuntimeException("SKU not found: " + skuId));

        skuMapper.updateEntityFromDto(updatedSku, existing);

        SKUEntity saved = skuRepository.save(existing);
        return skuMapper.toDTO(saved);
    }

    @Transactional
    public int bulkAddFromFile(MultipartFile file, boolean upsert) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;
        List<SKUEntity> skusToSave = new ArrayList<>();

        boolean isFirstLine = true;
        while ((line = reader.readLine()) != null) {
            // Skip header line
            if (isFirstLine) {
                isFirstLine = false;
                if (line.toLowerCase().contains("name") && line.contains(",")) {
                    continue;
                }
            }

            String[] cols = line.split(",");
            if (cols.length < 3) continue; // skip malformed line

            String name = cols[0].trim();
            long price;
            try {
                price = Long.parseLong(cols[1].trim());
            } catch (NumberFormatException e) {
                continue; // skip bad line
            }
            String skuCode = cols[2].trim();

            Optional<SKUEntity> existingOpt = skuRepository.findBySkuCode(skuCode);
            if (existingOpt.isPresent()) {
                if (upsert) {
                    SKUEntity existing = existingOpt.get();
                    existing.setName(name);
                    existing.setPriceInCents(price);
                    existing.setSkuCode(skuCode);
                    skusToSave.add(existing);
                }
            } else {
                SKUEntity newSku = new SKUEntity(name, price, skuCode);
                skusToSave.add(newSku);
            }
        }

        skuRepository.saveAll(skusToSave);
        return skusToSave.size();
    }
}
