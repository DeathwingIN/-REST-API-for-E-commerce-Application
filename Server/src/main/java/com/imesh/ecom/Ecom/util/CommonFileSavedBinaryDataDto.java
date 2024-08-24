package com.imesh.ecom.Ecom.util;

import lombok.*;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;

/**
 * CommonFileSavedBinaryDataDto is a data transfer object used to store binary data and metadata for files.
 * It includes fields for a unique hash, directory, file name, and resource URL.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonFileSavedBinaryDataDto {

    // SPECIFIC KEY FOR AWS TO IDENTIFY DATA UNIQUE
    private Blob hash;
    private String directory;
    private Blob fileName;
    private Blob resourceUrl;

    /**
     * Constructs a new CommonFileSavedBinaryDataDto with the specified parameters.
     *
     * @param hash        the unique hash of the file
     * @param directory   the directory where the file is stored
     * @param fileName    the name of the file
     * @param resourceUrl the URL of the resource
     */
    public CommonFileSavedBinaryDataDto(SerialBlob hash, String directory, SerialBlob fileName, SerialBlob resourceUrl) {
    }
}