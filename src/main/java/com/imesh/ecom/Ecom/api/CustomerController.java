package com.imesh.ecom.Ecom.api;


import com.imesh.ecom.Ecom.dto.request.RequestCustomerDto;
import com.imesh.ecom.Ecom.service.CustomerService;
import com.imesh.ecom.Ecom.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {



//    CRUD Methods

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCustomerDto dto) {
        customerService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Customer was created!..",null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> get(@PathVariable String id) {
        return new ResponseEntity<>(
                new StandardResponse(200,"Customer data!..",customerService.findById(id)),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")

    public ResponseEntity<StandardResponse> update(@PathVariable String id,
                                                   @RequestBody RequestCustomerDto dto) {// update data // http://localhost:8001/api/v1/customers [PUT]
        customerService.update(id,dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Customer was updated!..",null),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<StandardResponse> delete(@PathVariable String id) {// remove data // http://localhost:8001/api/v1/customers [DELETE]
        customerService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"Customer was deleted!..",null),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ) {// find data // http://localhost:8001/api/v1/customers/list [GET]

        return new ResponseEntity<>(
                new StandardResponse(200,"Customer list!..",
                        customerService.findAll(searchText, page, size)),
                HttpStatus.OK
        );
    }
}
