package com.imesh.ecom.Ecom.repo;

import com.imesh.ecom.Ecom.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, String> {
    Product findByPropertyId(String propertyId);
}
