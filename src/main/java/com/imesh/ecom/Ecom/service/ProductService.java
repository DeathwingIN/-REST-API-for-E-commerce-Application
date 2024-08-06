package com.imesh.ecom.Ecom.service;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;
import com.imesh.ecom.Ecom.dto.request.RequestProductDto;
import com.imesh.ecom.Ecom.dto.response.ResponseCustomerDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.CustomerPaginationDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.ProductPaginationDto;

public interface ProductService {

    public void create(RequestProductDto dto);

    public ResponseCustomerDto findById(String id);

    public void update(String id, ResponseCustomerDto dto);

    public ProductPaginationDto findAll(String searchText, int page, int size);

    public void delete(String id);



}
