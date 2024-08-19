package com.imesh.ecom.Ecom.service;

import com.imesh.ecom.Ecom.dto.request.RequestProductDto;
import com.imesh.ecom.Ecom.dto.response.ResponseCustomerDto;
import com.imesh.ecom.Ecom.dto.response.ResponseProductDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.ProductPaginationDto;

public interface ProductService {

    public void create(RequestProductDto dto);

    public ResponseProductDto findById(String id);


    void update(String id, ResponseProductDto dto);

    public ProductPaginationDto findAll(String searchText, int page, int size);

    public void delete(String id);



}
