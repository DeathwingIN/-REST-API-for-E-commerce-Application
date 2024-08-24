package com.imesh.ecom.Ecom.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import com.imesh.ecom.Ecom.service.FileService;
import com.imesh.ecom.Ecom.util.CommonFileSavedBinaryDataDto;
import com.imesh.ecom.Ecom.util.ImageUploadGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

/**
 * FileServiceImpl is a service implementation for managing file operations with Amazon S3.
 * It provides methods for creating, deleting, and downloading files.
 */
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final AmazonS3 s3;
    private final AmazonS3Client s3Client;
    private final ImageUploadGenerator imageUploadGenerator;

    /**
     * Creates a new resource in the specified S3 bucket and directory.
     *
     * @param file      the file to be uploaded
     * @param directory the directory in the S3 bucket where the file will be stored
     * @param bucket    the name of the S3 bucket
     * @return a DTO containing the saved file's binary data and metadata
     * @throws RuntimeException if an error occurs during file upload
     */
    @Override
    public CommonFileSavedBinaryDataDto createResource(MultipartFile file, String directory, String bucket) {
        try {
            String originalFilename = file.getOriginalFilename();
            String newFileName = imageUploadGenerator.generateEcomResourceName(originalFilename, UUID.randomUUID().toString());
            PutObjectResult putObjectResult = s3Client.putObject(new
                    PutObjectRequest(bucket, directory + "/" + newFileName, file.getInputStream(),
                    new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead));

            return new CommonFileSavedBinaryDataDto(
                    new SerialBlob(putObjectResult.getContentMd5().getBytes()),
                    directory,
                    new SerialBlob(newFileName.getBytes()),
                    new SerialBlob(s3Client.getResourceUrl(bucket, directory + newFileName).getBytes())
            );
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deletes a resource from the specified S3 bucket and directory.
     *
     * @param fileName  the name of the file to be deleted
     * @param directory the directory in the S3 bucket where the file is stored
     * @param bucket    the name of the S3 bucket
     */
    @Override
    public void deleteResource(String fileName, String directory, String bucket) {
        s3Client.deleteObject(bucket, directory + "/" + fileName);
    }

    /**
     * Downloads a file from the specified S3 bucket.
     *
     * @param fileName the name of the file to be downloaded
     * @param bucket   the name of the S3 bucket
     * @return a byte array containing the file's data
     * @throws RuntimeException if an error occurs during file download
     */
    @Override
    public byte[] downloadFile(String fileName, String bucket) {
        S3Object object = s3.getObject(bucket, fileName);
        S3ObjectInputStream objectContent = object.getObjectContent();
        try {
            return IOUtils.toByteArray(objectContent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}