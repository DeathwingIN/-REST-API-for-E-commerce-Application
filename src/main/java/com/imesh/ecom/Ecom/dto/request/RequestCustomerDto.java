package com.imesh.ecom.Ecom.dto.request;


import lombok.*;

//To ACCESS DATA
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

//Used for send data to CustomerController (Customer Object)
public class RequestCustomerDto {

    private String name;
    private String email;
    private String phone;
    private String address;
    private Boolean isActive;


}
