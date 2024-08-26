package com.imesh.ecom.Ecom.dto.response.pagiation;

import com.imesh.ecom.Ecom.dto.response.ResponseCustomerOrderDto;
import lombok.*;

import java.util.List;

/**
 * CustomerOrderPaginationDto is a data transfer object used for paginating customer orders.
 * It contains the total count of customer orders and a list of ResponseCustomerOrderDto objects.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerOrderPaginationDto {

    /**
     * The total count of customer orders.
     */
    private long count;

    /**
     * The list of customer orders.
     */
    private List<ResponseCustomerOrderDto> dataList;
}