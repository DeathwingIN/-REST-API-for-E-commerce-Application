package com.imesh.ecom.Ecom.dto.response;





import lombok.*;

import java.util.List;


//To ACCESS DATA
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class ResponseProductDto {

    private String propertyId;
    private Long qty;
    private Double unitPrice;
    private String description;
    List<ResponseProductImageDto> productImages;





}
