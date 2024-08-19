package com.imesh.ecom.Ecom.api;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;
import com.imesh.ecom.Ecom.dto.request.RequestCustomerOrderDto;
import com.imesh.ecom.Ecom.service.CustomerOrderService;
import com.imesh.ecom.Ecom.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TO ACCESS ROUTE
@RestController
@RequestMapping("api/v1/customer_orders")
@RequiredArgsConstructor

public class CustomerOrderController {

    //TO ACCESS SERVICE
    private final CustomerOrderService customerOrderService;

    //TO CALL METHOD
    //RequestBody PASS DATA THROUGH BODY CHECK POSTMAN
    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCustomerOrderDto dto) {
        customerOrderService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer Order Created", null),
                HttpStatus.CREATED);
    }


    //PathVariable WHERE WE GET ID{URL/id}
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> get(@PathVariable String id) {
        return new ResponseEntity<>(new StandardResponse(200, "Customer Data", customerOrderService.findById(id)), HttpStatus.OK);
    }




    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAll(
            //SEARCH AND PAGINATION
            @RequestParam String customerId,
            @RequestParam int page,
            @RequestParam int size) {
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer List",
                        customerOrderService.findAll(customerId, page, size)),
                HttpStatus.CREATED);


    }


    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id) {
        customerOrderService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(204, "Customer Order Deleted", null),
                HttpStatus.NO_CONTENT);

    }


}
