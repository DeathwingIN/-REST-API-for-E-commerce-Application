package com.imesh.ecom.Ecom.service;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;
import com.imesh.ecom.Ecom.dto.response.ResponseCustomerDto;

public interface CustomerService {

    public void create(RequestCustomerDto dto);

    public ResponseCustomerDto findById(String id);

    public void update(String id, RequestCustomerDto dto);

}
