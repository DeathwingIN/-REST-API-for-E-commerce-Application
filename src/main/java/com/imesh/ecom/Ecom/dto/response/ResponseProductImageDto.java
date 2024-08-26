package com.imesh.ecom.Ecom.dto.response;

import lombok.*;

/**
 * ResponseProductImageDto is a data transfer object used to send product image data.
 * It contains fields for image details such as property ID, directory, resource URL, hash, and file name.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseProductImageDto {

    /**
     * The property ID of the product image.
     */
    private String propertyId;

    /**
     * The directory where the product image is stored.
     */
    private String directory;

    /**
     * The resource URL of the product image.
     */
    private String resourceUrl;

    /**
     * The hash of the product image.
     */
    private String hash;

    /**
     * The file name of the product image.
     */
    private String fileName;
}