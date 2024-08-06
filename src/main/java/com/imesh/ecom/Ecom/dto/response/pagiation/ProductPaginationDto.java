package com.imesh.ecom.Ecom.dto.response.pagiation;

import com.imesh.ecom.Ecom.dto.response.ResponseCustomerDto;
import com.imesh.ecom.Ecom.dto.response.ResponseProductDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class ProductPaginationDto {


    private long count;
    private List<ResponseProductDto> dataList;

}
