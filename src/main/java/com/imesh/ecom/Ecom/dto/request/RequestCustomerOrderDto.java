package com.imesh.ecom.Ecom.dto.request;

import com.imesh.ecom.Ecom.entity.enums.PaymentType;
import lombok.*;

import java.util.Date;

/**
 * RequestCustomerOrderDto is a data transfer object used to send customer order data.
 * It contains fields for order details such as creation date, total amount, quantity, payment type, customer ID, and product ID.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestCustomerOrderDto {

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
     * The payment type for the order.
     */
    private PaymentType type;

    /**
     * The ID of the customer who placed the order.
     */
    private String customer;

    /**
     * The ID of the product being ordered.
     */
    private String product;
}