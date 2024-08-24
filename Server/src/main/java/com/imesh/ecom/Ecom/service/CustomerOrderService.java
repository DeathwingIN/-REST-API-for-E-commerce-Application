package com.imesh.ecom.Ecom.service;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;
import com.imesh.ecom.Ecom.dto.request.RequestCustomerOrderDto;
import com.imesh.ecom.Ecom.dto.response.ResponseCustomerDto;
import com.imesh.ecom.Ecom.dto.response.ResponseCustomerOrderDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.CustomerOrderPaginationDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.CustomerPaginationDto;

/**
 * CustomerOrderService is an interface for managing customer orders.
 * It provides methods for creating, finding, updating, and deleting customer orders.
 */
public interface CustomerOrderService {

    /**
     * Creates a new customer order.
     *
     * @param dto the data transfer object containing the details of the customer order to be created
     */
    public void create(RequestCustomerOrderDto dto);

    /**
     * Finds a customer order by its ID.
     *
     * @param id the ID of the customer order to be found
     * @return the response DTO containing the details of the found customer order
     */
    public ResponseCustomerOrderDto findById(String id);

    /**
     * Updates a customer order.
     *
     * @param id  the ID of the customer order to be updated
     * @param dto the data transfer object containing the updated details of the customer order
     */
    public void update(String id, RequestCustomerOrderDto dto);

    /**
     * Finds all customer orders for a given customer ID with pagination support.
     *
     * @param customerId the ID of the customer
     * @param page       the page number to retrieve
     * @param size       the number of records per page
     * @return the pagination DTO containing the list of customer orders and the total count
     */
    public CustomerOrderPaginationDto findAll(String customerId, int page, int size);

    /**
     * Deletes a customer order by its ID.
     *
     * @param id the ID of the customer order to be deleted
     */
    public void delete(String id);
}