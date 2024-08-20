package com.imesh.ecom.Ecom.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Customer is an entity that represents a customer in the e-commerce system.
 * It contains fields for customer details such as property ID, name, email, phone, address, and active status.
 * It also maintains a set of customer orders.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "customer")
public class Customer {

    /**
     * The property ID of the customer.
     */
    @Id
    @Column(name = "property_id", nullable = false, unique = true, length = 80)
    private String propertyId;

    /**
     * The name of the customer.
     */
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    /**
     * The email of the customer.
     */
    @Column(name = "email", unique = true, length = 100, nullable = false)
    private String email;

    /**
     * The phone number of the customer.
     */
    @Column(name = "phone", nullable = false, length = 45)
    private String phone;

    /**
     * The address of the customer.
     */
    @Column(name = "address", nullable = false, length = 255)
    private String address;

    /**
     * The active status of the customer.
     */
    @Column(name = "isActive", columnDefinition = "TINYINT")
    private Boolean isActive;

    /**
     * The set of orders associated with the customer.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<CustomerOrder> orders = new HashSet<>();
}