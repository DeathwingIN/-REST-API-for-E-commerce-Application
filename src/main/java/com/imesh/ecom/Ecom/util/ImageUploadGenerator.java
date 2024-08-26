package com.imesh.ecom.Ecom.util;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * ImageUploadGenerator is a service class for generating unique resource names for e-commerce images.
 * It provides a method to generate a unique resource name based on a given name and type.
 */
@Service
public class ImageUploadGenerator {

    /**
     * Generates a unique resource name for an e-commerce image.
     *
     * @param name the original name of the resource
     * @param type the type of the resource
     * @return the generated unique resource name
     */
    public String generateEcomResourceName(String name, String type) {
        StringBuilder builder = new StringBuilder();
        builder.append(UUID.randomUUID().toString());
        builder.append("-DS-");
        builder.append(type).append("-");
        builder.append(name);
        return builder.toString();
    }
}