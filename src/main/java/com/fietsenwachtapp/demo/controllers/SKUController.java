package com.fietsenwachtapp.demo.controllers;

import com.fietsenwachtapp.demo.DTOs.SkuCreateDTO;
import com.fietsenwachtapp.demo.DTOs.SkuDTO;
import com.fietsenwachtapp.demo.services.SKUService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/services/sku")
public class SKUController {

    @Autowired
    SKUService skuService;

    //TODO make pagination possible
    @GetMapping("/list")
    public ResponseEntity<List<SkuDTO>> getSKUList() {
        return ResponseEntity.ok(skuService.getSKUList());
    }

    @PostMapping("/add")
    public ResponseEntity<SkuDTO> addSKU(@Valid @RequestBody SkuCreateDTO skuToAdd) {
        return ResponseEntity.ok(skuService.addSKU(skuToAdd));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SkuDTO> updateSKU(
            @PathVariable("id") UUID skuId,
            @RequestBody SkuCreateDTO updatedSku) {
        return ResponseEntity.ok(skuService.updateSKU(skuId, updatedSku));
    }

    @Operation(summary = "Delete SKU", description = "Deletes SKU based on the given ID")
    @ApiResponse(
            responseCode = "200",
            description = "Boolean indicating whether the deletion was successful",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = boolean.class, description = "true if deleted successfully, false otherwise")
            )
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteSKU(@PathVariable("id") UUID skuId) {
        return ResponseEntity.ok(skuService.deleteSKU(skuId));
    }

    @PostMapping("/file-upload")
    public ResponseEntity<String> bulkUploadSKUs(@RequestParam("file") MultipartFile file, @RequestBody boolean isUpsert) throws IOException {
        return ResponseEntity.ok("Imported " + skuService.bulkAddFromFile(file, isUpsert) + " SKUs");
    }
}
