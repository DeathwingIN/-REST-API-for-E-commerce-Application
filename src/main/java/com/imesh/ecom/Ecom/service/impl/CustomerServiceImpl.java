package com.imesh.ecom.Ecom.service.impl;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;
import com.imesh.ecom.Ecom.dto.response.ResponseCustomerDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.CustomerPaginationDto;
import com.imesh.ecom.Ecom.entity.Customer;
import com.imesh.ecom.Ecom.exception.EntryNotFoundException;
import com.imesh.ecom.Ecom.repo.CustomerRepo;
import com.imesh.ecom.Ecom.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * CustomerServiceImpl is a service implementation for managing customers.
 * It provides methods for creating, finding, updating, and deleting customers.
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    /**
     * Creates a new customer.
     *
     * @param dto the data transfer object containing the details of the customer to be created
     */
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

    /**
     * Finds a customer by its ID.
     *
     * @param id the ID of the customer to be found
     * @return the response DTO containing the details of the found customer
     * @throws EntryNotFoundException if the customer is not found
     */
    @Override
    public ResponseCustomerDto findById(String id) {
        Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if (selectedCustomer.isEmpty()) {
            throw new EntryNotFoundException("Customer Not Found");
        }
        return toResponseCustomerDto(selectedCustomer.get());
    }

    /**
     * Updates a customer.
     *
     * @param id  the ID of the customer to be updated
     * @param dto the data transfer object containing the updated details of the customer
     */
    @Override
    public void update(String id, RequestCustomerDto dto) {
        Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if (selectedCustomer.isEmpty()) {
            throw new RuntimeException("Customer Not Found");
        }
        Customer customer = selectedCustomer.get();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        customer.setIsActive(dto.getIsActive());
        customerRepo.save(customer);
    }

    /**
     * Finds all customers matching the search text with pagination support.
     *
     * @param searchText the text to search for in the customer fields
     * @param page       the page number to retrieve
     * @param size       the number of records per page
     * @return the pagination DTO containing the list of customers and the total count
     */
    @Override
    public CustomerPaginationDto findAll(String searchText, int page, int size) {
        return CustomerPaginationDto.builder()
                .dataList(customerRepo.findAllWithSearchText(searchText, PageRequest.of(page, size))
                        .stream().map(this::toResponseCustomerDto).toList())
                .count(customerRepo.countAllWithSearchText(searchText))
                .build();
    }

    /**
     * Deletes a customer by its ID.
     *
     * @param id the ID of the customer to be deleted
     */
    @Override
    public void delete(String id) {
        customerRepo.deleteById(id);
    }

    /**
     * Converts a Customer entity to a ResponseCustomerDto.
     *
     * @param customer the customer entity
     * @return the response DTO containing the details of the customer
     */
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