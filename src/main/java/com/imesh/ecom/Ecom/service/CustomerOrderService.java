package com.imesh.ecom.Ecom.service;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;
import com.imesh.ecom.Ecom.dto.request.RequestCustomerOrderDto;
import com.imesh.ecom.Ecom.dto.response.ResponseCustomerDto;
import com.imesh.ecom.Ecom.dto.response.ResponseCustomerOrderDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.CustomerOrderPaginationDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.CustomerPaginationDto;

public interface CustomerOrderService {

    public void create(RequestCustomerOrderDto dto);

    public ResponseCustomerOrderDto findById(String id);

    public void update(String id, RequestCustomerOrderDto dto);

    public CustomerOrderPaginationDto findAll(String customerId, int page, int size);

    public void delete(String id);



}
