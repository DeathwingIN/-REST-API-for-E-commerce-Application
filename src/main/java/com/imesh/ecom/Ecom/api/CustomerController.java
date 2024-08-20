package com.imesh.ecom.Ecom.api;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;
import com.imesh.ecom.Ecom.service.CustomerService;
import com.imesh.ecom.Ecom.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CustomerController is a REST controller that handles HTTP requests for customer-related operations.
 * It provides endpoints for creating, retrieving, updating, and deleting customers, as well as listing customers with pagination and search functionality.
 */
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    // Service to handle customer-related operations
    private final CustomerService customerService;

    /**
     * Creates a new customer.
     *
     * @param dto the data transfer object containing customer details
     * @return a ResponseEntity containing a StandardResponse with a 201 status code and a success message
     */
    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCustomerDto dto) {
        customerService.create(dto);
        return new ResponseEntity<>(new StandardResponse(201, "Customer Created", null), HttpStatus.CREATED);
    }

    /**
     * Retrieves a customer by ID.
     *
     * @param id the ID of the customer to retrieve
     * @return a ResponseEntity containing a StandardResponse with a 200 status code and the customer data
     */
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> get(@PathVariable String id) {
        return new ResponseEntity<>(new StandardResponse(200, "Customer Data", customerService.findById(id)), HttpStatus.OK);
    }

    /**
     * Updates an existing customer.
     *
     * @param id  the ID of the customer to update
     * @param dto the data transfer object containing updated customer details
     * @return a ResponseEntity containing a StandardResponse with a 201 status code and a success message
     */
    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> update(@PathVariable String id, @RequestBody RequestCustomerDto dto) {
        customerService.update(id, dto);
        return new ResponseEntity<>(new StandardResponse(201, "Customer Updated", null), HttpStatus.CREATED);
    }

    /**
     * Retrieves a list of customers with pagination and search functionality.
     *
     * @param searchText the text to search for in customer records
     * @param page       the page number to retrieve
     * @param size       the number of records per page
     * @return a ResponseEntity containing a StandardResponse with a 201 status code and the list of customers
     */
    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size) {
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer List",
                        customerService.findAll(searchText, page, size)),
                HttpStatus.CREATED);
    }

    /**
     * Deletes a customer by ID.
     *
     * @param id the ID of the customer to delete
     * @return a ResponseEntity containing a StandardResponse with a 204 status code and a success message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id) {
        customerService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(204, "Customer Deleted", null),
                HttpStatus.NO_CONTENT);
    }
}