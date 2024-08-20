package com.imesh.ecom.Ecom.dto.response;

import lombok.*;

/**
 * ResponseCustomerDto is a data transfer object used to send customer data to the CustomerController.
 * It contains fields for customer details such as property ID, name, email, phone, address, and active status.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseCustomerDto {

    /**
     * The property ID of the customer.
     */
    private String propertyId;

    /**
     * The name of the customer.
     */
    private String name;

    /**
     * The email of the customer.
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