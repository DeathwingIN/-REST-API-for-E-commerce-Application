package com.imesh.ecom.Ecom.service;

import com.imesh.ecom.Ecom.dto.request.RequestProductDto;
import com.imesh.ecom.Ecom.dto.response.ResponseProductDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.ProductPaginationDto;

/**
 * ProductService is an interface for managing products.
 * It provides methods for creating, finding, updating, and deleting products.
 */
public interface ProductService {

    /**
     * Creates a new product.
     *
     * @param dto the data transfer object containing the details of the product to be created
     */
    public void create(RequestProductDto dto);

    /**
     * Finds a product by its ID.
     *
     * @param id the ID of the product to be found
     * @return the response DTO containing the details of the found product
     */
    public ResponseProductDto findById(String id);

    /**
     * Updates a product.
     *
     * @param id  the ID of the product to be updated
     * @param dto the data transfer object containing the updated details of the product
     */
    void update(String id, RequestProductDto dto);

    /**
     * Finds all products matching the search text with pagination support.
     *
     * @param searchText the text to search for in the product fields
     * @param page       the page number to retrieve
     * @param size       the number of records per page
     * @return the pagination DTO containing the list of products and the total count
     */
    public ProductPaginationDto findAll(String searchText, int page, int size);

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to be deleted
     */
    public void delete(String id);
}