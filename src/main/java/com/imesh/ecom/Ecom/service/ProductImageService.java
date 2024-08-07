package com.imesh.ecom.Ecom.service;


import com.imesh.ecom.Ecom.dto.request.RequestProductImageDto;
import com.imesh.ecom.Ecom.dto.response.ResponseProductImageDto;
import com.imesh.ecom.Ecom.dto.response.pagiation.CustomerPaginationDto;

import java.io.IOException;
import java.sql.SQLException;

public interface ProductImageService {
    public void create(RequestProductImageDto dto, String productId) throws SQLException, IOException;
    public ResponseProductImageDto findById(String id);
    public void delete(String id);
}
