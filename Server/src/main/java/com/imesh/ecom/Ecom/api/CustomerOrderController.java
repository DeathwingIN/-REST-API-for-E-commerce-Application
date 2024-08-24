package com.imesh.ecom.Ecom.api;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerOrderDto;
import com.imesh.ecom.Ecom.service.CustomerOrderService;
import com.imesh.ecom.Ecom.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CustomerOrderController is a REST controller that handles HTTP requests for customer order-related operations.
 * It provides endpoints for creating, retrieving, and deleting customer orders, as well as listing customer orders with pagination and search functionality.
 */
@RestController
@RequestMapping("api/v1/customer_orders")
@RequiredArgsConstructor
public class CustomerOrderController {

    // Service to handle customer order-related operations
    private final CustomerOrderService customerOrderService;

    /**
     * Creates a new customer order.
     *
     * @param dto the data transfer object containing customer order details
     * @return a ResponseEntity containing a StandardResponse with a 201 status code and a success message
     */
    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCustomerOrderDto dto) {
        customerOrderService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer Order Created", null),
                HttpStatus.CREATED);
    }

    /**
     * Retrieves a customer order by ID.
     *
     * @param id the ID of the customer order to retrieve
     * @return a ResponseEntity containing a StandardResponse with a 200 status code and the customer order data
     */
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> get(@PathVariable String id) {
        return new ResponseEntity<>(new StandardResponse(200, "Customer Data", customerOrderService.findById(id)), HttpStatus.OK);
    }

    /**
     * Retrieves a list of customer orders with pagination and search functionality.
     *
     * @param customerId the ID of the customer to search for in customer orders
     * @param page       the page number to retrieve
     * @param size       the number of records per page
     * @return a ResponseEntity containing a StandardResponse with a 201 status code and the list of customer orders
     */
    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam String customerId,
            @RequestParam int page,
            @RequestParam int size) {
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer List",
                        customerOrderService.findAll(customerId, page, size)),
                HttpStatus.CREATED);
    }

    /**
     * Deletes a customer order by ID.
     *
     * @param id the ID of the customer order to delete
     * @return a ResponseEntity containing a StandardResponse with a 204 status code and a success message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id) {
        customerOrderService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(204, "Customer Order Deleted", null),
                HttpStatus.NO_CONTENT);
    }
}