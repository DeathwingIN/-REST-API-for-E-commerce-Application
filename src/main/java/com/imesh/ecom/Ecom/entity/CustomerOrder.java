package com.imesh.ecom.Ecom.entity;


import com.imesh.ecom.Ecom.entity.enums.PaymentType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

// @Data Dont USE WITH ENTITY ISSUE WITH PERFORMANCE BECAUSE IN THAT OBJECT IT CONSISTS SOME CLASS THAT AFFECT PERFORMANCE
@Entity(name = "customer_order")

public class CustomerOrder {
    @Id
    @Column(name = "property_id", nullable = false, unique = true,  length = 80)
    private String propertyId;

    @Column(name = "created_date",columnDefinition = "DATETIME",nullable = false)
    private Date createdDate;

    private double total;
    private int qty;
    private PaymentType type;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "property_id")
    private Customer customer;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "property_id")
    private Product product;

}
