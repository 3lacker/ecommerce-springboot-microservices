package com.example.inventory.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.inventory.dto.InventoryDTO;
import com.example.inventory.model.Inventory;

@Component
public class InventoryMapper {
    public InventoryDTO toDto(Inventory entity) {
        return InventoryDTO.builder()
                .id(entity.getId())
                .productCode(entity.getProductCode())
                .quantity(entity.getQuantity())
                .build();
    }

    public Inventory toEntity(InventoryDTO dto) {
        return Inventory.builder()
                .id(dto.getId())
                .productCode(dto.getProductCode())
                .quantity(dto.getQuantity())
                .build();
    }
     public List<Inventory> toEntity(List<InventoryDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }
    public List<InventoryDTO> toDto(List<Inventory> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

}
