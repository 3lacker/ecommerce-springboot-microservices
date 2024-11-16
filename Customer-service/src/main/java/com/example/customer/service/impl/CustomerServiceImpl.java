package com.example.customer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.example.customer.dto.CustomerDTO;
import com.example.customer.mapper.CustomerMapper;
import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        log.info("Fetching all customers");
        return  customerMapper.toDto(customerRepository.findAll());
    }
    @Override
    public Optional<CustomerDTO> getCustomerById(Long id) {
        log.info("Fetching customer with id: {}", id);
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Customer not found"));

        return Optional.of(customerMapper.toDto(customer));
    }
    @Override

    public Customer addCustomer(CustomerDTO customer) {
        log.info("Adding new customer: {}", customer.getId());
        return customerRepository.save(customerMapper.toEntity(customer));
    }
    @Override
    public Customer updateCustomer(Long id, CustomerDTO customerDto) {
        log.info("Updating customerDto with id: {}", id);
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Customer not found"));
        customer.setFullName(customerDto.getFullName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setEmail(customerDto.getEmail());
        if (customerDto.getPassword() != null) {
            customer.setPassword(customerDto.getPassword());
            
        }

        return customerRepository.save(customer);
    }
    @Override
    public void deleteCustomer(Long id) {
        log.info("Deleting customer with id: {}", id);
        customerRepository.deleteById(id);
    }


}

