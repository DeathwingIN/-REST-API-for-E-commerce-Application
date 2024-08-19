package com.imesh.ecom.Ecom.service.impl;

import com.imesh.ecom.Ecom.dto.request.RequestProductDto;
import com.imesh.ecom.Ecom.dto.response.ResponseCustomerDto;
import com.imesh.ecom.Ecom.dto.response.ResponseProductDto;
import com.imesh.ecom.Ecom.dto.response.ResponseProductImageDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.ProductPaginationDto;
import com.imesh.ecom.Ecom.entity.Product;
import com.imesh.ecom.Ecom.entity.ProductImage;
import com.imesh.ecom.Ecom.exception.EntryNotFoundException;
import com.imesh.ecom.Ecom.repo.ProductRepo;
import com.imesh.ecom.Ecom.service.ProductService;
import com.imesh.ecom.Ecom.util.FileDataExtractor;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductServiceImpl implements ProductService {


    private ProductRepo productRepo;
    private FileDataExtractor fileDataExtractor;

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

    @Override
    public ResponseProductDto findById(String id) {
        Optional <Product> selectedProduct = productRepo.findById(id);
        if (selectedProduct.isEmpty()) {
           throw new EntryNotFoundException("Product not found");
        }
        return createResponseProductDto(selectedProduct.get());
    }


    @Override
    public void update(String id, ResponseProductDto dto) {
        Optional <Product> selectedProduct = productRepo.findById(id);
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

    @Override
    public ProductPaginationDto findAll(String searchText, int page, int size) {
        //To get and Iterate  list
        return ProductPaginationDto.builder()

                .dataList(productRepo.findAllWithSearchText(searchText, PageRequest.of(page, size))
                        .stream().map(this::createResponseProductDto).toList())
                .count(productRepo.countAllWithSearchText(searchText))
                .build();

    }

    @Override
    public void delete(String id) {
        productRepo.deleteById(id);
    }

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
