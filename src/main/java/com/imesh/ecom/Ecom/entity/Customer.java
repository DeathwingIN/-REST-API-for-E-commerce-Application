package com.imesh.ecom.Ecom.entity;


import jakarta.persistence.*;
import lombok.*;


import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

// @Data Dont USE WITH ENTITY ISSUE WITH PERFORMANCE BECAUSE IN THAT OBJECT IT CONSISTS SOME CLASS THAT AFFECT PERFORMANCE
@Entity(name = "customer")


//NAME ALWAYS = TO TABLE NAME
public class Customer {

    @Id
    @Column(name = "property_id", nullable = false, unique = true,  length = 80)
    private String propertyId;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "email", unique = true, length = 100, nullable = false)
    private String email;

    @Column(name = "phone", nullable = false, length = 45)
    private String phone;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "isActive", columnDefinition = "TINYINT")
    private Boolean isActive;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer")
    private Set<CustomerOrder> orders = new HashSet<>();

}
