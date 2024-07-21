package com.imesh.ecom.Ecom.api;


import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;
import com.imesh.ecom.Ecom.servide.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor


public class CustomerController {


    private final CustomerService customerService;

    @PostMapping
    public String create(@RequestBody RequestCustomerDto requestCustomerDto) {
        customerService.create(requestCustomerDto);
        return "Create() ";
    }

    @GetMapping("/{id}")
    public String gerById(@PathVariable String id) {
        return "gerById() ";
    }


    @PutMapping
    public String update(@RequestBody RequestCustomerDto requestCustomerDto) {
        return "update() ";
    }

    @GetMapping("/list")
    public String findAll(
            @RequestParam String searchText,
            @RequestParam int size,
            @RequestParam int page
    ) {
        return "findAll() ";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return "delete() ";
    }

}


