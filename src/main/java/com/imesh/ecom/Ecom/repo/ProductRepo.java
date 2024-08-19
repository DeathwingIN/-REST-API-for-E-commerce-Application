package com.imesh.ecom.Ecom.repo;

import com.imesh.ecom.Ecom.entity.Customer;
import com.imesh.ecom.Ecom.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product, String> {

    @Query(value = "SELECT * FROM product WHERE description LIKE %?1%  ORDER BY name DESC", nativeQuery = true)
    public Page<Product> findAllWithSearchText(String searchText, Pageable pageable);


    @Query(value = "SELECT COUNT(*) FROM product WHERE description  LIKE %?1%  ", nativeQuery = true)
    public long countAllWithSearchText(String searchText);

}
