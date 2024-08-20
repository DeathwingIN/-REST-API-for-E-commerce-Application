package com.imesh.ecom.Ecom.service;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;
import com.imesh.ecom.Ecom.dto.response.ResponseCustomerDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.CustomerPaginationDto;

/**
 * CustomerService is an interface for managing customers.
 * It provides methods for creating, finding, updating, and deleting customers.
 */
public interface CustomerService {

    /**
     * Creates a new customer.
     *
     * @param dto the data transfer object containing the details of the customer to be created
     */
    public void create(RequestCustomerDto dto);

    /**
     * Finds a customer by its ID.
     *
     * @param id the ID of the customer to be found
     * @return the response DTO containing the details of the found customer
     */
    public ResponseCustomerDto findById(String id);

    /**
     * Updates a customer.
     *
     * @param id  the ID of the customer to be updated
     * @param dto the data transfer object containing the updated details of the customer
     */
    public void update(String id, RequestCustomerDto dto);

    /**
     * Finds all customers matching the search text with pagination support.
     *
     * @param searchText the text to search for in the customer fields
     * @param page       the page number to retrieve
     * @param size       the number of records per page
     * @return the pagination DTO containing the list of customers and the total count
     */
    public CustomerPaginationDto findAll(String searchText, int page, int size);

    /**
     * Deletes a customer by its ID.
     *
     * @param id the ID of the customer to be deleted
     */
    public void delete(String id);
}