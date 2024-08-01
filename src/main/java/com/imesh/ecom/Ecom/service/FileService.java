package com.imesh.ecom.Ecom.service;

import com.imesh.ecom.Ecom.util.CommonFileSavedBinaryDataDto;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {


    public CommonFileSavedBinaryDataDto create(MultipartFile file,String directory, String bucket);
    public void delete(String fileName, String directory, String bucket);

}

