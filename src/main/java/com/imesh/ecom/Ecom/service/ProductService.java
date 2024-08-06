package com.imesh.ecom.Ecom.service;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;
import com.imesh.ecom.Ecom.dto.response.ResponseCustomerDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.CustomerPaginationDto;

public interface ProductService {

    public void create(RequestCustomerDto dto);

    public ResponseCustomerDto findById(String id);

    public void update(String id, RequestCustomerDto dto);

    public CustomerPaginationDto findAll(String searchText,int page, int size);

    public void delete(String id);



}
