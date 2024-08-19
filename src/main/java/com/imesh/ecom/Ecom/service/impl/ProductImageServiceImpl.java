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


@RequiredArgsConstructor
@Service
public class ProductImageServiceImpl implements ProductImageService {


    @Value("${aws.bucket_name}")
    private String bucketName;

    private final ProductImageRepo productImageRepo;
    private final ProductRepo productRepo;
    private final FileService fileService;
    private final FileDataExtractor dataExtractor;


    @Override
    public void create(MultipartFile file, String productId) throws SQLException, IOException {

        CommonFileSavedBinaryDataDto resource = null;

        try {
            Optional<Product> selectedProduct = productRepo.findById(productId);
            if (selectedProduct.isEmpty()) {
                throw new EntryNotFoundException("Product not found");
            }


            //THIS PASS DATA THAT CONVERT TO BINARY FORMAT
            resource = fileService.createResource(file, "ecom/product_images", bucketName);


            ProductImage productImage = ProductImage.
                    builder()
                    .propertyId(UUID.randomUUID().toString())
                    .hash(dataExtractor.blobToByteArray(
                            resource.getHash()
                    ))
                    .directory(resource.getDirectory().getBytes())
                    .fileName(dataExtractor.blobToByteArray(
                            resource.getFileName()
                    ))
                    .resourceUrl(dataExtractor.blobToByteArray(
                            resource.getResourceUrl()
                    ))
                    .product(selectedProduct.get())
                    .build();

            productImageRepo.save(productImage);

        } catch (Exception e) {
            fileService.deleteResource(bucketName, resource.getDirectory(),
                    dataExtractor.extractActualFileName(
                            new InputStreamReader(resource.getFileName().getBinaryStream())));
            throw new InternalServerException("Something went wrong");
        }


    }

    @Override
    public ResponseProductImageDto findById(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
