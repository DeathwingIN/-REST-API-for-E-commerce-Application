package com.imesh.ecom.Ecom.repo;

import com.imesh.ecom.Ecom.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * CustomerRepo is a repository interface for managing Customer entities.
 * It extends JpaRepository to provide CRUD operations and custom query methods.
 */
public interface CustomerRepo extends JpaRepository<Customer, String> {

    /**
     * Finds all customers whose address, email, or name contains the given search text, with pagination support.
     * The results are ordered by name in descending order.
     *
     * @param searchText the text to search for in the address, email, or name fields
     * @param pageable   the pagination information
     * @return a page of customers matching the search criteria
     */
    @Query(value = "SELECT * FROM customer WHERE address LIKE %?1% OR email LIKE %?1% OR name LIKE %?1% ORDER BY name DESC", nativeQuery = true)
    Page<Customer> findAllWithSearchText(String searchText, Pageable pageable);

    /**
     * Counts the number of customers whose address, email, or name contains the given search text.
     *
     * @param searchText the text to search for in the address, email, or name fields
     * @return the count of customers matching the search criteria
     */
    @Query(value = "SELECT COUNT(*) FROM customer WHERE address LIKE %?1% OR email LIKE %?1% OR name LIKE %?1%", nativeQuery = true)
    long countAllWithSearchText(String searchText);
}