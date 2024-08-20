package com.imesh.ecom.Ecom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * EntryNotFoundException is a custom exception that is thrown when a requested entry is not found.
 * It returns a 404 Not Found HTTP status code.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntryNotFoundException extends RuntimeException {

    /**
     * Constructs a new EntryNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public EntryNotFoundException(String message) {
        super(message);
    }
}