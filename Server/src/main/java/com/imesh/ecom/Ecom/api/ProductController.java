package com.imesh.ecom.Ecom.api;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;
import com.imesh.ecom.Ecom.dto.request.RequestProductDto;
import com.imesh.ecom.Ecom.service.ProductService;
import com.imesh.ecom.Ecom.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ProductController is a REST controller that handles HTTP requests for product-related operations.
 * It provides endpoints for creating, retrieving, updating, and deleting products, as well as listing products with pagination and search functionality.
 */
@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    // Service to handle product-related operations
    private final ProductService productService;

    /**
     * Creates a new product.
     *
     * @param dto the data transfer object containing product details
     * @return a ResponseEntity containing a StandardResponse with a 201 status code and a success message
     */
    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestProductDto dto) {
        productService.create(dto);
        return new ResponseEntity<>(new StandardResponse(201, "Product Created", null), HttpStatus.CREATED);
    }

    /**
     * Retrieves a product by ID.
     *
     * @param id the ID of the product to retrieve
     * @return a ResponseEntity containing a StandardResponse with a 200 status code and the product data
     */
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> get(@PathVariable String id) {
        return new ResponseEntity<>(new StandardResponse(200, "Product Data", productService.findById(id)), HttpStatus.OK);
    }

    /**
     * Updates an existing product.
     *
     * @param id  the ID of the product to update
     * @param dto the data transfer object containing updated product details
     * @return a ResponseEntity containing a StandardResponse with a 201 status code and a success message
     */
    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> update(@PathVariable String id, @RequestBody RequestProductDto dto) {
        productService.update(id, dto);
        return new ResponseEntity<>(new StandardResponse(201, "Product Updated", null), HttpStatus.CREATED);
    }

    /**
     * Retrieves a list of products with pagination and search functionality.
     *
     * @param searchText the text to search for in product records
     * @param page       the page number to retrieve
     * @param size       the number of records per page
     * @return a ResponseEntity containing a StandardResponse with a 201 status code and the list of products
     */
    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size) {
        return new ResponseEntity<>(
                new StandardResponse(201, "Product List",
                        productService.findAll(searchText, page, size)),
                HttpStatus.CREATED);
    }

    /**
     * Deletes a product by ID.
     *
     * @param id the ID of the product to delete
     * @return a ResponseEntity containing a StandardResponse with a 204 status code and a success message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id) {
        productService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(204, "Product Deleted", null),
                HttpStatus.NO_CONTENT);
    }
}