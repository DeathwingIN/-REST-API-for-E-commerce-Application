package com.imesh.ecom.Ecom.util;


import lombok.*;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;

@Data
 @Builder
 @NoArgsConstructor
 @AllArgsConstructor

public class CommonFileSavedBinaryDataDto {


//    SPECIFIC KEY FOR AWS TO IDENTIFY DATA UNIQUE
    private Blob hash;
    private String directory;
    private Blob fileName;
    private Blob resourceUrl;

    public CommonFileSavedBinaryDataDto(SerialBlob hash, String directory, SerialBlob fileName, SerialBlob resourceUrl) {
    }
}
