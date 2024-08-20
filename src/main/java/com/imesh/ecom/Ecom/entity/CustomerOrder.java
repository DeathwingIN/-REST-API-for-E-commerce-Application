package com.imesh.ecom.Ecom.entity;

import com.imesh.ecom.Ecom.entity.enums.PaymentType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * CustomerOrder is an entity that represents a customer order in the e-commerce system.
 * It contains fields for order details such as property ID, created date, total amount, quantity, payment type, customer, and product.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "customer_order")
public class CustomerOrder {

    /**
     * The property ID of the order.
     */
    @Id
    @Column(name = "property_id", nullable = false, unique = true, length = 80)
    private String propertyId;

    /**
     * The date the order was created.
     */
    @Column(name = "created_date", columnDefinition = "DATETIME", nullable = false)
    private Date createdDate;

    /**
     * The total amount of the order.
     */
    private double total;

    /**
     * The quantity of items in the order.
     */
    private int qty;

    /**
     * The payment type of the order.
     */
    @Enumerated(value = EnumType.STRING)
    private PaymentType type;

    /**
     * The customer associated with the order.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "property_id")
    private Customer customer;

    /**
     * The product associated with the order.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "property_id")
    private Product product;
}