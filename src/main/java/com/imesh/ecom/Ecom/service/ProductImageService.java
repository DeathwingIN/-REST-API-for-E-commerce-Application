package com.imesh.ecom.Ecom.service;


import com.imesh.ecom.Ecom.dto.request.RequestProductImageDto;
import com.imesh.ecom.Ecom.dto.response.ResponseProductImageDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.CustomerPaginationDto;

public interface ProductImageService {
    public void create(RequestProductImageDto dto, String productId);
    public ResponseProductImageDto findById(String id);
    public CustomerPaginationDto findAll(String productId,int page, int size);
    public void delete(String id);
}
