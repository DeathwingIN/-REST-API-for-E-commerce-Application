package com.imesh.ecom.Ecom.dto.request;

import lombok.*;

/**
 * RequestCustomerDto is a data transfer object used to send customer data to the CustomerController.
 * It contains fields for customer details such as name, email, phone, address, and active status.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestCustomerDto {

    /**
     * The name of the customer.
     */
    private String name;

    /**
     * The email address of the customer.
     */
    private String email;

    /**
     * The phone number of the customer.
     */
    private String phone;

    /**
     * The address of the customer.
     */
    private String address;

    /**
     * The active status of the customer.
     */
    private Boolean isActive;
}