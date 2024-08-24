package com.imesh.ecom.Ecom.dto.response;

import lombok.*;

import java.util.List;

/**
 * ResponseProductDto is a data transfer object used to send product data.
 * It contains fields for product details such as property ID, quantity, unit price, description, and a list of product images.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseProductDto {

    /**
     * The property ID of the product.
     */
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
     * The list of product images.
     */
    private List<ResponseProductImageDto> productImages;
}