package com.imesh.ecom.Ecom.service.impl;

import com.amazonaws.services.account.model.InternalServerException;
import com.imesh.ecom.Ecom.dto.response.ResponseProductImageDto;
import com.imesh.ecom.Ecom.entity.Product;
import com.imesh.ecom.Ecom.entity.ProductImage;
import com.imesh.ecom.Ecom.exception.EntryNotFoundException;
import com.imesh.ecom.Ecom.repo.ProductImageRepo;
import com.imesh.ecom.Ecom.repo.ProductRepo;
import com.imesh.ecom.Ecom.service.FileService;
import com.imesh.ecom.Ecom.service.ProductImageService;
import com.imesh.ecom.Ecom.util.CommonFileSavedBinaryDataDto;
import com.imesh.ecom.Ecom.util.FileDataExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

/**
 * ProductImageServiceImpl is a service implementation for managing product images.
 * It provides methods for creating, finding, and deleting product images.
 */
@RequiredArgsConstructor
@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Value("${aws.bucket_name}")
    private String bucketName;

    private final ProductImageRepo productImageRepo;
    private final ProductRepo productRepo;
    private final FileService fileService;
    private final FileDataExtractor dataExtractor;

    /**
     * Creates a new product image.
     *
     * @param file      the file to be uploaded
     * @param productId the ID of the product to which the image belongs
     * @throws SQLException, IOException if an error occurs during file upload or database operations
     */
    @Override
    public void create(MultipartFile file, String productId) throws SQLException, IOException {
        CommonFileSavedBinaryDataDto resource = null;

        try {
            Optional<Product> selectedProduct = productRepo.findById(productId);
            if (selectedProduct.isEmpty()) {
                throw new EntryNotFoundException("Product not found");
            }

            // Convert file data to binary format and save to S3
            resource = fileService.createResource(file, "ecom/product_images", bucketName);

            ProductImage productImage = ProductImage.builder()
                    .propertyId(UUID.randomUUID().toString())
                    .hash(dataExtractor.blobToByteArray(resource.getHash()))
                    .directory(resource.getDirectory().getBytes())
                    .fileName(dataExtractor.blobToByteArray(resource.getFileName()))
                    .resourceUrl(dataExtractor.blobToByteArray(resource.getResourceUrl()))
                    .product(selectedProduct.get())
                    .build();

            productImageRepo.save(productImage);

        } catch (Exception e) {
            fileService.deleteResource(bucketName, resource.getDirectory(),
                    dataExtractor.extractActualFileName(new InputStreamReader(resource.getFileName().getBinaryStream())));
            throw new InternalServerException("Something went wrong");
        }
    }

    /**
     * Finds a product image by its ID.
     *
     * @param id the ID of the product image to be found
     * @return the response DTO containing the details of the found product image
     */
    @Override
    public ResponseProductImageDto findById(String id) {
        return null;
    }

    /**
     * Deletes a product image by its ID.
     *
     * @param id the ID of the product image to be deleted
     */
    @Override
    public void delete(String id) {
        // Implementation for deleting a product image
    }
}