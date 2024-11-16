package com.example.customer.service;
import com.example.customer.model.Customer;
import com.example.customer.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {


    List<CustomerDTO> getAllCustomers();

    Optional<CustomerDTO> getCustomerById(Long id);

    Customer addCustomer(CustomerDTO Customer);

    Customer updateCustomer(Long id, CustomerDTO CustomerDto);

    void deleteCustomer(Long id);
}
