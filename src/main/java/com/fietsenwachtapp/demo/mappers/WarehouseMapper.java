package com.fietsenwachtapp.demo.mappers;

import com.fietsenwachtapp.demo.DTOs.WarehouseCreateDTO;
import com.fietsenwachtapp.demo.DTOs.WarehouseDTO;
import com.fietsenwachtapp.demo.DTOs.WarehouseListDTO;
import com.fietsenwachtapp.demo.entities.WarehouseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper()
public interface WarehouseMapper {

    @Mapping(target = "address", source = "address")
    @Mapping(target = "inventory", source = "inventory")
    WarehouseDTO toDTO(WarehouseEntity warehouseEntity);

    @Mapping(target = "address", source = "address")
    WarehouseListDTO toListDTO(WarehouseEntity warehouseEntity);

    void updateEntityFromDto(WarehouseCreateDTO dto, @MappingTarget WarehouseEntity entity);

    @Mapping(target = "address", source = "address")
    WarehouseEntity toEntity(WarehouseCreateDTO updatedWarehouse);
}
