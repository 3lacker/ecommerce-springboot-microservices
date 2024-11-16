package com.example.product.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
    
    @Service
public class ProductService  {
    @Autowired
    private ProductRepository productRepository;

    
    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }
    
    public Optional<Product> getProductById(String id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Product not found"));

        return Optional.of(product);
    }
    

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    
    public Product updateProduct(String id, Product productdto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Product not found"));
        productdto.setId(product.getId());
        return productRepository.save(productdto);
    }
    
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }


}

