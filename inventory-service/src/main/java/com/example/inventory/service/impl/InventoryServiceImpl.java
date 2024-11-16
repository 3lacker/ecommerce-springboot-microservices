package com.example.inventory.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.example.inventory.model.Inventory;
import com.example.inventory.repository.InventoryRepository;
import com.example.inventory.service.InventoryService;
import com.example.inventory.dto.InventoryDTO;
import com.example.inventory.mapper.InventoryMapper;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    @Override
    public List<InventoryDTO> getAllInventorys() {
        log.info("Fetching all inventorys");
        return  inventoryMapper.toDto(inventoryRepository.findAll());
    }
    @Override
    public Optional<InventoryDTO> getInventoryById(Long id) {
        log.info("Fetching inventory with id: {}", id);
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Inventory not found"));

        return Optional.of(inventoryMapper.toDto(inventory));
    }
    @Override

    public Inventory addInventory(InventoryDTO inventory) {
        log.info("Adding new inventory: {}", inventory.getId());
        return inventoryRepository.save(inventoryMapper.toEntity(inventory));
    }
    @Override
    public Inventory updateInventory(Long id, InventoryDTO inventoryDto) {
        log.info("Updating inventoryDto with id: {}", id);
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Inventory not found"));
/*
    set attribute
*/
        inventory.setId(inventoryDto.getId());
        return inventoryRepository.save(inventory);
    }
    @Override
    public void deleteInventory(Long id) {
        log.info("Deleting inventory with id: {}", id);
        inventoryRepository.deleteById(id);
    }


}

