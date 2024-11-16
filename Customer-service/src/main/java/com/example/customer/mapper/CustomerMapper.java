package com.example.customer.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.customer.dto.CustomerDTO;
import com.example.customer.model.Customer;

@Component
public class CustomerMapper {
    public CustomerDTO toDto(Customer entity) {
        return CustomerDTO.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }

    public Customer toEntity(CustomerDTO dto) {
        return Customer.builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .password(dto.getPassword())
                .build();
    }
     public List<Customer> toEntity(List<CustomerDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }
    public List<CustomerDTO> toDto(List<Customer> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

}
