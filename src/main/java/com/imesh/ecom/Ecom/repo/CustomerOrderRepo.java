package com.imesh.ecom.Ecom.repo;

import com.imesh.ecom.Ecom.entity.CustomerOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * CustomerOrderRepo is a repository interface for managing CustomerOrder entities.
 * It extends JpaRepository to provide CRUD operations and custom query methods.
 */
public interface CustomerOrderRepo extends JpaRepository<CustomerOrder, String> {

    /**
     * Finds all customer orders for a given customer ID with pagination support.
     *
     * @param customerId the ID of the customer
     * @param pageable   the pagination information
     * @return a page of customer orders
     */
    @Query(value = "SELECT * FROM customer_order WHERE customer_id =?1", nativeQuery = true)
    Page<CustomerOrder> findAllWithSearchText(String customerId, Pageable pageable);

    /**
     * Counts the number of customer orders for a given customer ID.
     *
     * @param customerId the ID of the customer
     * @return the count of customer orders
     */
    @Query(value = "SELECT COUNT(*) FROM customer_order WHERE customer_id =?1", nativeQuery = true)
    long countAllWithSearchText(String customerId);
}