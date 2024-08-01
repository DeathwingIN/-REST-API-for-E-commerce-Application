package com.imesh.ecom.Ecom.util;


import lombok.*;

import java.sql.Blob;

@Data
 @Builder
 @NoArgsConstructor
 @AllArgsConstructor

public class CommonFileSavedBinaryDataDto {


//    SPECIFIC KEY FOR AWS TO IDENTIFY DATA UNIQUE
    private Blob hash;
    private Blob directory;
    private Blob fileName;
    private Blob resourceUrl;

}
