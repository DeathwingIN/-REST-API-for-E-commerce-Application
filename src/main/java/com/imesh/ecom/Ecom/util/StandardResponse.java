package com.imesh.ecom.Ecom.util;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardResponse {
    private int status;
    private String message;
    private Object data;
}