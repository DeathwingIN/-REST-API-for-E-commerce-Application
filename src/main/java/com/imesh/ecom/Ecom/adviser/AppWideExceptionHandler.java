package com.imesh.ecom.Ecom.adviser;

import com.imesh.ecom.Ecom.exception.EntryNotFoundException;
import com.imesh.ecom.Ecom.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * AppWideExceptionHandler is a global exception handler for the application.
 * It handles specific exceptions and returns appropriate HTTP responses.
 */
@RestControllerAdvice
public class AppWideExceptionHandler {

    /**
     * Handles EntryNotFoundException and returns a 404 Not Found response.
     *
     * @param e the EntryNotFoundException thrown when an entry is not found
     * @return a ResponseEntity containing a StandardResponse with a 404 status code and the exception message
     */
    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponse> handleEntryNotFoundException(EntryNotFoundException e) {
        return new ResponseEntity<>(
                new StandardResponse(
                        404, e.getMessage(), e), HttpStatus.NOT_FOUND
        );
    }
}