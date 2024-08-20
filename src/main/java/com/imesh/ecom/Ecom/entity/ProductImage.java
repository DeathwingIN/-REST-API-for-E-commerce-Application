package com.imesh.ecom.Ecom.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * ProductImage is an entity that represents an image associated with a product in the e-commerce system.
 * It contains fields for image details such as property ID, directory, file name, resource URL, and hash.
 * It also maintains a reference to the associated product.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "product_image")
public class ProductImage {

    /**
     * The property ID of the product image.
     */
    @Id
    @Column(name = "property_id", nullable = false, unique = true, length = 80)
    private String propertyId;

    /**
     * The directory where the product image is stored.
     */
    @Lob
    @Column(name = "directory", nullable = false)
    private byte[] directory;

    /**
     * The file name of the product image.
     */
    @Lob
    @Column(name = "file_name", nullable = false)
    private byte[] fileName;

    /**
     * The resource URL of the product image.
     */
    @Lob
    @Column(name = "resource_url", nullable = false)
    private byte[] resourceUrl;

    /**
     * The hash of the product image.
     */
    @Lob
    @Column(name = "hash", nullable = false)
    private byte[] hash;

    /**
     * The product associated with the product image.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "property_id")
    private Product product;
}