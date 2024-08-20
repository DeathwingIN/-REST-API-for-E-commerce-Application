package com.imesh.ecom.Ecom.api;

import com.imesh.ecom.Ecom.service.ProductImageService;
import com.imesh.ecom.Ecom.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

/**
 * ProductImageController is a REST controller that handles HTTP requests for product image-related operations.
 * It provides an endpoint for uploading product images.
 */
@RestController
@RequestMapping("api/v1/product-images")
@RequiredArgsConstructor
public class ProductImageController {

    // Service to handle product image-related operations
    private final ProductImageService productImageService;

    /**
     * Uploads a new product image.
     *
     * @param file    the MultipartFile containing the product image
     * @param product the ID of the product to associate the image with
     * @return a ResponseEntity containing a StandardResponse with a 201 status code and a success message
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an I/O error occurs
     */
    @PostMapping("/{product}")
    public ResponseEntity<StandardResponse> create(@RequestParam("productImage") MultipartFile file,
                                                   @PathVariable String product) throws SQLException, IOException {
        productImageService.create(file, product);
        return new ResponseEntity<>(new StandardResponse(201, "Product Created", null), HttpStatus.CREATED);
    }
}