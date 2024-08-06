package com.imesh.ecom.Ecom.repo;

import com.imesh.ecom.Ecom.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepo extends JpaRepository<CustomerOrder, String> {


}
