package com.imesh.ecom.Ecom.dto.response;


import com.imesh.ecom.Ecom.entity.enums.PaymentType;

import java.util.Date;


public class ResponseCustomerOrderDto {


    private String propertyId;
    private Date createdDate;
    private double total;
    private int qty;
    private PaymentType type;
    private String customer;
    private String product;

}
