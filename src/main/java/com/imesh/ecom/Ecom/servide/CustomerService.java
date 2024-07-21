package com.imesh.ecom.Ecom.servide;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;

public interface CustomerService {


    public default void create(RequestCustomerDto requestCustomerDto) {

    }


}
