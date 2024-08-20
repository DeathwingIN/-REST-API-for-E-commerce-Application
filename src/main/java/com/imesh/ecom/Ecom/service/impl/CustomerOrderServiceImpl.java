package com.imesh.ecom.Ecom.service.impl;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerOrderDto;
import com.imesh.ecom.Ecom.dto.response.ResponseCustomerOrderDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.CustomerOrderPaginationDto;
import com.imesh.ecom.Ecom.entity.Customer;
import com.imesh.ecom.Ecom.entity.CustomerOrder;
import com.imesh.ecom.Ecom.entity.Product;
import com.imesh.ecom.Ecom.exception.EntryNotFoundException;
import com.imesh.ecom.Ecom.repo.CustomerOrderRepo;
import com.imesh.ecom.Ecom.repo.CustomerRepo;
import com.imesh.ecom.Ecom.repo.ProductRepo;
import com.imesh.ecom.Ecom.service.CustomerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * CustomerOrderServiceImpl is a service implementation for managing customer orders.
 * It provides methods for creating, finding, updating, and deleting customer orders.
 */
@RequiredArgsConstructor
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private final CustomerOrderRepo customerOrderRepo;
    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;

    /**
     * Creates a new customer order.
     *
     * @param dto the data transfer object containing the details of the customer order to be created
     * @throws EntryNotFoundException if the customer or product specified in the DTO is not found
     */
    @Override
    public void create(RequestCustomerOrderDto dto) {
        Optional<Customer> selectedCustomer = customerRepo.findById(dto.getCustomer());
        if (selectedCustomer.isEmpty()) {
            throw new EntryNotFoundException("Customer Not Found");
        }

        Optional<Product> selectedProduct = productRepo.findById(dto.getProduct());
        if (selectedProduct.isEmpty()) {
            throw new EntryNotFoundException("Product not found");
        }

        CustomerOrder customerOrder = CustomerOrder.builder()
                .propertyId(UUID.randomUUID().toString())
                .customer(selectedCustomer.get())
                .createdDate(dto.getCreatedDate())
                .product(selectedProduct.get())
                .total(dto.getTotal())
                .qty(dto.getQty())
                .build();
        customerOrderRepo.save(customerOrder);
    }

    /**
     * Finds a customer order by its ID.
     *
     * @param id the ID of the customer order to be found
     * @return the response DTO containing the details of the found customer order
     * @throws EntryNotFoundException if the customer order is not found
     */
    @Override
    public ResponseCustomerOrderDto findById(String id) {
        Optional<CustomerOrder> selectedOrder = customerOrderRepo.findById(id);
        if (selectedOrder.isEmpty()) {
            throw new EntryNotFoundException("Order Not Found");
        }
        return createCustomerOrderDto(selectedOrder.get());
    }

    /**
     * Updates a customer order.
     *
     * @param id  the ID of the customer order to be updated
     * @param dto the data transfer object containing the updated details of the customer order
     */
    @Override
    public void update(String id, RequestCustomerOrderDto dto) {
        // Implementation for updating a customer order
    }

    /**
     * Finds all customer orders for a given customer ID with pagination support.
     *
     * @param customerId the ID of the customer
     * @param page       the page number to retrieve
     * @param size       the number of records per page
     * @return the pagination DTO containing the list of customer orders and the total count
     */
    @Override
    public CustomerOrderPaginationDto findAll(String customerId, int page, int size) {
        return CustomerOrderPaginationDto.builder()
                .dataList(customerOrderRepo.findAllWithSearchText(customerId, PageRequest.of(page, size))
                        .stream().map(this::createCustomerOrderDto).toList())
                .count(customerOrderRepo.countAllWithSearchText(customerId))
                .build();
    }

    /**
     * Deletes a customer order by its ID.
     *
     * @param id the ID of the customer order to be deleted
     */
    @Override
    public void delete(String id) {
        customerOrderRepo.deleteById(id);
    }

    /**
     * Creates a response DTO from a customer order entity.
     *
     * @param o the customer order entity
     * @return the response DTO containing the details of the customer order
     */
    private ResponseCustomerOrderDto createCustomerOrderDto(CustomerOrder o) {
        return ResponseCustomerOrderDto.builder()
                .propertyId(o.getPropertyId())
                .createdDate(o.getCreatedDate())
                .customer(o.getCustomer().getName())
                .product(o.getProduct().getDescription())
                .total(o.getTotal())
                .qty(o.getQty())
                .build();
    }
}