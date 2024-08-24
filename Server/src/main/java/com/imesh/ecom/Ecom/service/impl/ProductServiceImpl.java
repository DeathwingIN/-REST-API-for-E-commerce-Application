package com.imesh.ecom.Ecom.service.impl;

import com.imesh.ecom.Ecom.dto.request.RequestProductDto;
import com.imesh.ecom.Ecom.dto.response.ResponseProductDto;
import com.imesh.ecom.Ecom.dto.response.ResponseProductImageDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.ProductPaginationDto;
import com.imesh.ecom.Ecom.entity.Product;
import com.imesh.ecom.Ecom.entity.ProductImage;
import com.imesh.ecom.Ecom.exception.EntryNotFoundException;
import com.imesh.ecom.Ecom.repo.ProductRepo;
import com.imesh.ecom.Ecom.service.ProductService;
import com.imesh.ecom.Ecom.util.FileDataExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * ProductServiceImpl is a service implementation for managing products.
 * It provides methods for creating, finding, updating, and deleting products.
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final FileDataExtractor fileDataExtractor;

    /**
     * Creates a new product.
     *
     * @param dto the data transfer object containing the details of the product to be created
     */
    @Override
    public void create(RequestProductDto dto) {
        Product product = Product.builder()
                .description(dto.getDescription())
                .qty(dto.getQty())
                .unitPrice(dto.getUnitPrice())
                .propertyId(UUID.randomUUID().toString())
                .build();
        productRepo.save(product);
    }

    /**
     * Finds a product by its ID.
     *
     * @param id the ID of the product to be found
     * @return the response DTO containing the details of the found product
     * @throws EntryNotFoundException if the product is not found
     */
    @Override
    public ResponseProductDto findById(String id) {
        Optional<Product> selectedProduct = productRepo.findById(id);
        if (selectedProduct.isEmpty()) {
            throw new EntryNotFoundException("Product not found");
        }
        return createResponseProductDto(selectedProduct.get());
    }

    /**
     * Updates a product.
     *
     * @param id  the ID of the product to be updated
     * @param dto the data transfer object containing the updated details of the product
     * @throws EntryNotFoundException if the product is not found
     */
    @Override
    public void update(String id, RequestProductDto dto) {
        Optional<Product> selectedProduct = productRepo.findById(id);
        if (selectedProduct.isEmpty()) {
            throw new EntryNotFoundException("Product not found");
        }
        Product product = Product.builder()
                .description(dto.getDescription())
                .qty(dto.getQty())
                .unitPrice(dto.getUnitPrice())
                .propertyId(id)
                .build();
        productRepo.save(product);
    }

    /**
     * Finds all products matching the search text with pagination support.
     *
     * @param searchText the text to search for in the product fields
     * @param page       the page number to retrieve
     * @param size       the number of records per page
     * @return the pagination DTO containing the list of products and the total count
     */
    @Override
    public ProductPaginationDto findAll(String searchText, int page, int size) {
        return ProductPaginationDto.builder()
                .dataList(productRepo.findAllWithSearchText(searchText, PageRequest.of(page, size))
                        .stream().map(this::createResponseProductDto).toList())
                .count(productRepo.countAllWithSearchText(searchText))
                .build();
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to be deleted
     */
    @Override
    public void delete(String id) {
        productRepo.deleteById(id);
    }

    /**
     * Converts a Product entity to a ResponseProductDto.
     *
     * @param product the product entity
     * @return the response DTO containing the details of the product
     */
    private ResponseProductDto createResponseProductDto(Product product) {
        List<ResponseProductImageDto> images = product.getImages().stream().map(
                this::createResponseProductImage
        ).toList();

        return ResponseProductDto.builder()
                .description(product.getDescription())
                .qty(product.getQty())
                .unitPrice(product.getUnitPrice())
                .propertyId(product.getPropertyId())
                .productImages(images)
                .build();
    }

    /**
     * Converts a ProductImage entity to a ResponseProductImageDto.
     *
     * @param i the product image entity
     * @return the response DTO containing the details of the product image
     */
    private ResponseProductImageDto createResponseProductImage(ProductImage i) {
        return ResponseProductImageDto.builder()
                .hash(fileDataExtractor.byteArrayToString(i.getHash()))
                .directory(fileDataExtractor.byteArrayToString(i.getDirectory()))
                .resourceUrl(fileDataExtractor.byteArrayToString(i.getResourceUrl()))
                .fileName(fileDataExtractor.byteArrayToString(i.getFileName()))
                .propertyId(i.getPropertyId())
                .build();
    }
}