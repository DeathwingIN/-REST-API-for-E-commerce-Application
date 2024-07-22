package com.imesh.ecom.Ecom.service.impl;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;
import com.imesh.ecom.Ecom.entity.Customer;
import com.imesh.ecom.Ecom.repo.CustomerRepo;
import com.imesh.ecom.Ecom.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service

//TO INITIALIZE
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Override
    public void create(RequestCustomerDto dto) {

        Customer customer = Customer.builder()
                .propertyId(UUID.randomUUID().toString())
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .isActive(dto.getIsActive())
                .build();
        customerRepo.save(customer);

    }
}
