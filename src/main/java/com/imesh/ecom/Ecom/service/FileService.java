package com.imesh.ecom.Ecom.service;

import com.imesh.ecom.Ecom.util.CommonFileSavedBinaryDataDto;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {


    public CommonFileSavedBinaryDataDto createResource(MultipartFile file, String directory, String bucket);

    public void deleteResource(String fileName, String directory, String bucket);

    public byte[] downloadFile(String fileName, String bucket);

}

