package com.example.customer.controller;

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

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import com.example.customer.dto.CustomerDTO;

import lombok.AllArgsConstructor;





@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAllCustomer() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<CustomerDTO> getById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }


    @PostMapping
    public Customer addCustomer(@RequestBody CustomerDTO customer) {        
        return customerService.addCustomer(customer);
    }
    @PutMapping("/{id}")
    public Customer addCustomer(@PathVariable Long id , @RequestBody CustomerDTO customer) {

        return customerService.updateCustomer(id,customer);
    }


    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "Customer deleted successfully";
    }
    
    
    

    
}

