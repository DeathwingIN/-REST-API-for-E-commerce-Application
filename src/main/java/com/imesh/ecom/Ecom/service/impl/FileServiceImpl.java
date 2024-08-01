package com.imesh.ecom.Ecom.service.impl;

import com.imesh.ecom.Ecom.service.FileService;
import com.imesh.ecom.Ecom.util.CommonFileSavedBinaryDataDto;
import org.springframework.web.multipart.MultipartFile;

public class FileServiceImpl implements FileService {
    @Override
    public CommonFileSavedBinaryDataDto create(MultipartFile file, String directory, String bucket) {
        return null;
    }

    @Override
    public void delete(String fileName, String directory, String bucket) {

    }
}
