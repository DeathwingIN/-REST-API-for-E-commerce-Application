package com.imesh.ecom.Ecom.dto.response.pagiation;

import com.imesh.ecom.Ecom.dto.response.ResponseCustomerDto;
import lombok.*;

import java.util.List;

/**
 * CustomerPaginationDto is a data transfer object used for paginating customer data.
 * It contains the total count of customers and a list of ResponseCustomerDto objects.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerPaginationDto {

    /**
     * The total count of customers.
     */
    private long count;

    /**
     * The list of customer data.
     */
    private List<ResponseCustomerDto> dataList;
}