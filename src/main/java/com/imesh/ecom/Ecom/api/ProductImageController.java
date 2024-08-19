package com.imesh.ecom.Ecom.api;

import com.imesh.ecom.Ecom.service.ProductImageService;
import com.imesh.ecom.Ecom.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

//TO ACCESS ROUTE
@RestController
@RequestMapping("api/v1/product-images")
@RequiredArgsConstructor

public class ProductImageController {

    //TO ACCESS SERVICE
    private final ProductImageService productImageService;

    //TO CALL METHOD
    //RequestBody PASS DATA THROUGH BODY CHECK POSTMAN
    @PostMapping("/{product}")
    public ResponseEntity<StandardResponse> create(@RequestParam("productImage") MultipartFile file,
                                                   @PathVariable String product) throws SQLException, IOException {
        productImageService.create(file, product);
        return new ResponseEntity<>(new StandardResponse(201, "Product Created", null), HttpStatus.CREATED);
    }


}
