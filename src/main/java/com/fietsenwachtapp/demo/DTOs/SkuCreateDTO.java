package com.fietsenwachtapp.demo.DTOs;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SkuCreateDTO(@NotBlank String name, @NotNull @Positive long priceInCents, @NotBlank String skuCode) {

}
