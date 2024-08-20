package com.imesh.ecom.Ecom.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * S3Config is a configuration class that sets up the Amazon S3 client for the application.
 * It reads AWS credentials and configuration properties from the application properties file.
 */
@Configuration
public class S3Config {

    @Value("${aws.access_key}")
    private String accessKey;

    @Value("${aws.secret}")
    private String secret;

    @Value("${aws.bucket_name}")
    private String bucketName;

    @Value("${aws.region}")
    private String region;

    /**
     * Creates an AmazonS3 bean using the provided AWS credentials and region.
     *
     * @return an AmazonS3 client configured with the specified credentials and region
     */
    @Bean
    public AmazonS3 s3() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secret);
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(region)
                .build();
    }

    /**
     * Creates an AmazonS3Client bean using the provided AWS credentials and region.
     *
     * @return an AmazonS3Client configured with the specified credentials and region
     */
    @Bean
    public AmazonS3Client s3Client() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secret);
        return (AmazonS3Client) AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(region)
                .build();
    }
}