package com.imesh.ecom.Ecom.dto.request;

import lombok.*;

/**
 * RequestProductDto is a data transfer object used to send product data.
 * It contains fields for product details such as quantity, unit price, and description.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestProductDto {

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
}