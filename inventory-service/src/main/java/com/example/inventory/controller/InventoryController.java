package com.example.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.dto.InventoryDTO;
import com.example.inventory.model.Inventory;
import com.example.inventory.service.InventoryService;

import lombok.AllArgsConstructor;





@RestController
@RequestMapping("/api/inventories")
@AllArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    public List<InventoryDTO> getAllInventory() {
        return inventoryService.getAllInventorys();
    }

    @GetMapping("/{id}")
    public Optional<InventoryDTO> getById(@PathVariable Long id) {
        return inventoryService.getInventoryById(id);
    }


    @PostMapping
    public Inventory addInventory(@RequestBody InventoryDTO inventory) {        
        return inventoryService.addInventory(inventory);
    }
    @PutMapping("/{id}")
    public Inventory addInventory(@PathVariable Long id , @RequestBody InventoryDTO inventory) {

        return inventoryService.updateInventory(id,inventory);
    }


    @DeleteMapping("/{id}")
    public String deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return "Inventory deleted successfully";
    }
    
    
    

    
}

