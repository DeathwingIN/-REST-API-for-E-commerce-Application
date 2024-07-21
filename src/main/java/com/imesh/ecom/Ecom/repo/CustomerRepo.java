package com.imesh.ecom.Ecom.repo;

import com.imesh.ecom.Ecom.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, String> {

}
