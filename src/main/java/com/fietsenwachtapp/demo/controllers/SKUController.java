package com.fietsenwachtapp.demo.controllers;

import com.fietsenwachtapp.demo.DTOs.SkuCreateDTO;
import com.fietsenwachtapp.demo.DTOs.SkuDTO;
import com.fietsenwachtapp.demo.services.SKUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/services/sku")
public class SKUController {

    @Autowired
    SKUService skuService;

    @GetMapping("/list")
    public ResponseEntity<List<SkuDTO>> getSKUList() {
        return ResponseEntity.ok(skuService.getSKUList()) ;
    }
    @PostMapping("/add")
    public ResponseEntity<SkuDTO> addSKU(@RequestBody SkuCreateDTO skuToAdd) {
        return ResponseEntity.ok(skuService.addSKU(skuToAdd)) ;
    }
}
