package com.imesh.ecom.Ecom.dto.response;


import lombok.*;

//To ACCESS DATA
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

//Used for send data to CustomerController (Customer Object)
public class ResponseCustomerDto {

    private String propertyId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Boolean isActive;


}
