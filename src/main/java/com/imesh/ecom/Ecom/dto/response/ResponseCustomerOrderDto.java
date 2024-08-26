package com.imesh.ecom.Ecom.dto.response;

import com.imesh.ecom.Ecom.entity.enums.PaymentType;
import lombok.*;

import java.util.Date;

/**
 * ResponseCustomerOrderDto is a data transfer object used to send customer order data.
 * It contains fields for order details such as property ID, created date, total amount, quantity, payment type, customer, and product.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseCustomerOrderDto {

    /**
     * The property ID of the order.
     */
    private String propertyId;

    /**
     * The date the order was created.
     */
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
    private PaymentType type;

    /**
     * The customer associated with the order.
     */
    private String customer;

    /**
     * The product associated with the order.
     */
    private String product;
}