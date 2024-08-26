package com.imesh.ecom.Ecom.service;

import com.imesh.ecom.Ecom.util.CommonFileSavedBinaryDataDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * FileService is an interface for managing file operations.
 * It provides methods for creating, deleting, and downloading files.
 */
public interface FileService {

    /**
     * Creates a new resource in the specified S3 bucket and directory.
     *
     * @param file      the file to be uploaded
     * @param directory the directory in the S3 bucket where the file will be stored
     * @param bucket    the name of the S3 bucket
     * @return a DTO containing the saved file's binary data and metadata
     */
    public CommonFileSavedBinaryDataDto createResource(MultipartFile file, String directory, String bucket);

    /**
     * Deletes a resource from the specified S3 bucket and directory.
     *
     * @param fileName  the name of the file to be deleted
     * @param directory the directory in the S3 bucket where the file is stored
     * @param bucket    the name of the S3 bucket
     */
    public void deleteResource(String fileName, String directory, String bucket);

    /**
     * Downloads a file from the specified S3 bucket.
     *
     * @param fileName the name of the file to be downloaded
     * @param bucket   the name of the S3 bucket
     * @return a byte array containing the file's data
     */
    public byte[] downloadFile(String fileName, String bucket);
}