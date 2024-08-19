package com.imesh.ecom.Ecom.service.impl;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerOrderDto;
import com.imesh.ecom.Ecom.dto.response.ResponseCustomerOrderDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.CustomerOrderPaginationDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.ProductPaginationDto;
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


@RequiredArgsConstructor
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {


    private CustomerOrderRepo customerOrderRepo;
    private CustomerRepo customerRepo;
    private ProductRepo productRepo;

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

    @Override
    public ResponseCustomerOrderDto findById(String id) {
        Optional<CustomerOrder> selectedOrder = customerOrderRepo.findById(id);
        if (selectedOrder.isEmpty()) {
            throw new EntryNotFoundException("Order Not Found");
        }
        return createCustomerOrderDto(selectedOrder.get());
    }

    @Override
    public void update(String id, RequestCustomerOrderDto dto) {

    }

    @Override
    public CustomerOrderPaginationDto findAll(String customerId, int page, int size) {

        return CustomerOrderPaginationDto.builder()

                .dataList(customerOrderRepo.findAllWithSearchText(customerId, PageRequest.of(page, size))
                        .stream().map(this::createCustomerOrderDto).toList())
                .count(customerOrderRepo.countAllWithSearchText(customerId))
                .build();

    }

    @Override
    public void delete(String id) {
    customerOrderRepo.deleteById(id);
    }


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
