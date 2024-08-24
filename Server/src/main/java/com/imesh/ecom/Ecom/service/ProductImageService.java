package com.imesh.ecom.Ecom.service;

import com.imesh.ecom.Ecom.dto.response.ResponseProductImageDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

/**
 * ProductImageService is an interface for managing product images.
 * It provides methods for creating, finding, and deleting product images.
 */
public interface ProductImageService {

    /**
     * Creates a new product image.
     *
     * @param file      the file to be uploaded
     * @param productId the ID of the product to which the image belongs
     * @throws SQLException, IOException if an error occurs during file upload or database operations
     */
    public void create(MultipartFile file, String productId) throws SQLException, IOException;

    /**
     * Finds a product image by its ID.
     *
     * @param id the ID of the product image to be found
     * @return the response DTO containing the details of the found product image
     */
    public ResponseProductImageDto findById(String id);

    /**
     * Deletes a product image by its ID.
     *
     * @param id the ID of the product image to be deleted
     */
    public void delete(String id);
}