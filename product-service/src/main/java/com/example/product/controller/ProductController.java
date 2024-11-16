package com.example.product.controller;

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

import com.example.product.model.Product;
import com.example.product.service.ProductService;

import lombok.AllArgsConstructor;





@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable String id) {
        return productService.getProductById(id);
    }


    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    @PutMapping("/{id}")
    public Product addProduct(@PathVariable String id , @RequestBody Product product) {

        return productService.updateProduct(id,product);
    }


    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }
    
    
    

    
}

