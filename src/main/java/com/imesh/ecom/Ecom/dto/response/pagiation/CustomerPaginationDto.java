package com.imesh.ecom.Ecom.dto.response.pagiation;

import com.imesh.ecom.Ecom.dto.response.ResponseCustomerDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class CustomerPaginationDto {


    private long count;
    private List<ResponseCustomerDto> dataList;

}
