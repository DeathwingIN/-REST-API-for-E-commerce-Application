package com.imesh.ecom.Ecom.api;

import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;
import com.imesh.ecom.Ecom.service.CustomerService;
import com.imesh.ecom.Ecom.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TO ACCESS ROUTE
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor

public class CustomerController {

    //TO ACCESS SERVICE
    private final CustomerService customerService;

    //TO CALL METHOD
    //RequestBody PASS DATA THROUGH BODY CHECK POSTMAN
    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCustomerDto dto) {
        customerService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer Created", null),
                HttpStatus.CREATED
        );
    }


    //PathVariable WHERE WE GET ID{URL/id}
    @GetMapping("/{id}")
    public String get(@PathVariable String id) {
        return "Customer Found";
    }

    @PutMapping
    public String update(@RequestBody RequestCustomerDto dto) {
        return "Customer Updated";
    }


    @GetMapping("/list")
    public String getAll(
            //SEARCH AND PAGINATION
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ) {


        return "Customer List";
    }

//
//    @GetMapping("/{id}")
//    public String delete(@PathVariable String id) {
//        return "Customer Deleted";
//    }


}
