package com.imesh.ecom.Ecom.service.impl;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;
import com.imesh.ecom.Ecom.dto.response.ResponseCustomerDto;
import com.imesh.ecom.Ecom.entity.Customer;
import com.imesh.ecom.Ecom.repo.CustomerRepo;
import com.imesh.ecom.Ecom.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
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

    @Override
    public ResponseCustomerDto findById(String id) {
        Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if (selectedCustomer.isEmpty()) {
            throw new RuntimeException("Customer Not Found");
        }
        return toResponseCustomerDto(selectedCustomer.get());
    }

    @Override
    public void update(String id, RequestCustomerDto dto) {
        Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if (selectedCustomer.isEmpty()) {
            throw new RuntimeException("Customer Not Found");
        }
        Customer customer= selectedCustomer.get();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        customer.setIsActive(dto.getIsActive());

        customerRepo.save(customer);

    }

    private ResponseCustomerDto toResponseCustomerDto(Customer customer) {
        return ResponseCustomerDto.builder()
                .propertyId(customer.getPropertyId())
                .name(customer.getName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .isActive(customer.getIsActive())
                .build();
    }
}
