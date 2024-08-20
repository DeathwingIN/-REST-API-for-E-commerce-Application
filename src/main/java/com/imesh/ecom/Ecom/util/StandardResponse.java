package com.imesh.ecom.Ecom.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * StandardResponse is a data transfer object used to encapsulate standard responses.
 * It includes fields for status, message, and data.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardResponse {

    /**
     * The status code of the response.
     */
    private int status;

    /**
     * The message associated with the response.
     */
    private String message;

    /**
     * The data payload of the response.
     */
    private Object data;
}