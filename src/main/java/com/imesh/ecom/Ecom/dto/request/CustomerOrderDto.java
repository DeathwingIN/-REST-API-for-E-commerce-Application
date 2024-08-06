package com.imesh.ecom.Ecom.dto.request;



import com.imesh.ecom.Ecom.entity.enums.PaymentType;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CustomerOrderDto {


    private Date createdDate;
    private double total;
    private int qty;
    private PaymentType type;

    private String customer;
    private String product;

}
