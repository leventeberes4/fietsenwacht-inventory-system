package com.fietsenwachtapp.demo.DTOs;

import java.util.UUID;

public record SkuDTO (UUID skuId, String name,long priceInCents, String skuCode){
}
