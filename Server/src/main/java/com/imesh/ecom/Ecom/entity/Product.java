package com.imesh.ecom.Ecom.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Product is an entity that represents a product in the e-commerce system.
 * It contains fields for product details such as property ID, quantity, unit price, and description.
 * It also maintains a set of product images and customer orders.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "product")
public class Product {

    /**
     * The property ID of the product.
     */
    @Id
    @Column(name = "property_id", nullable = false, unique = true, length = 80)
    private String propertyId;

    /**
     * The quantity of the product.
     */
    private Long qty;

    /**
     * The unit price of the product.
     */
    private Double unitPrice;

    /**
     * The description of the product.
     */
    private String description;

    /**
     * The set of images associated with the product.
     */
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProductImage> images = new HashSet<>();

    /**
     * The set of orders associated with the product.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<CustomerOrder> orders = new HashSet<>();
}