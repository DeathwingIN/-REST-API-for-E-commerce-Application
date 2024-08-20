package com.imesh.ecom.Ecom.dto.response.pagiation;

import com.imesh.ecom.Ecom.dto.response.ResponseProductDto;
import lombok.*;

import java.util.List;

/**
 * ProductPaginationDto is a data transfer object used for paginating product data.
 * It contains the total count of products and a list of ResponseProductDto objects.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductPaginationDto {

    /**
     * The total count of products.
     */
    private long count;

    /**
     * The list of product data.
     */
    private List<ResponseProductDto> dataList;
}