package com.fietsenwachtapp.demo.mappers;

import com.fietsenwachtapp.demo.DTOs.SkuCreateDTO;
import com.fietsenwachtapp.demo.DTOs.SkuDTO;
import com.fietsenwachtapp.demo.entities.SKUEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper()
public interface SkuMapper {

    @Mapping(target = "skuId", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "priceInCents", source = "priceInCents")
    SkuDTO toDTO(SKUEntity skuEntity);

    SKUEntity toSKUEntity(SkuCreateDTO skuCreateDTO);

    void updateEntityFromDto(SkuCreateDTO updatedSku, @MappingTarget SKUEntity entity);
}
