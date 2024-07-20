package com.imesh.ecom.Ecom.dto.request;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class RequestCustomerDto {
    private String name;
    private String email;
    private String phone;
    private String address;
    private boolean active;


}
