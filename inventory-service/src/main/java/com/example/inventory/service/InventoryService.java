package com.example.inventory.service;
import com.example.inventory.model.Inventory;
import com.example.inventory.dto.InventoryDTO;

import java.util.List;
import java.util.Optional;

public interface InventoryService {


    List<InventoryDTO> getAllInventorys();

    Optional<InventoryDTO> getInventoryById(Long id);

    Inventory addInventory(InventoryDTO Inventory);

    Inventory updateInventory(Long id, InventoryDTO InventoryDto);

    void deleteInventory(Long id);
}
