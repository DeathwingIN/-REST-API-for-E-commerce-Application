package com.imesh.ecom.Ecom.api;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;

import com.imesh.ecom.Ecom.service.ProductService;
import com.imesh.ecom.Ecom.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TO ACCESS ROUTE
@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor

public class ProductController {

    //TO ACCESS SERVICE
    private  ProductService productService;
    //TO CALL METHOD
    //RequestBody PASS DATA THROUGH BODY CHECK POSTMAN
    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCustomerDto dto) {
        productService.create(dto);
        return new ResponseEntity<>(new StandardResponse(201, "Customer Created", null), HttpStatus.CREATED);
    }


    //PathVariable WHERE WE GET ID{URL/id}
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> get(@PathVariable String id) {
        return new ResponseEntity<>(new StandardResponse(200, "Customer Data", customerService.findById(id)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> update(@PathVariable String id, @RequestBody RequestCustomerDto dto) {
        productService.update(id, dto);
        return new ResponseEntity<>(new StandardResponse(201, "Customer Updated", null), HttpStatus.CREATED);
    }


    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAll(
            //SEARCH AND PAGINATION
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size) {
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer List",
                        productService.findAll(searchText, page, size)),
                HttpStatus.CREATED);


    }


    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id) {
        productService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(204, "Customer Deleted", null),
                HttpStatus.NO_CONTENT);

    }


}
