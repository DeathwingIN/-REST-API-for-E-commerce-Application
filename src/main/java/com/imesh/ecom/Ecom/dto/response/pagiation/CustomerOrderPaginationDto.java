package com.imesh.ecom.Ecom.dto.response.pagiation;


import com.imesh.ecom.Ecom.dto.response.ResponseCustomerOrderDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class CustomerOrderPaginationDto {


    private long count;
    private List<ResponseCustomerOrderDto> dataList;

}
