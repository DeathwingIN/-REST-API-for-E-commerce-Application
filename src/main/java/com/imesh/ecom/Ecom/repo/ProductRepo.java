package com.imesh.ecom.Ecom.repo;

import com.imesh.ecom.Ecom.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * ProductRepo is a repository interface for managing Product entities.
 * It extends JpaRepository to provide CRUD operations and custom query methods.
 */
public interface ProductRepo extends JpaRepository<Product, String> {

    /**
     * Finds all products whose description contains the given search text, with pagination support.
     * The results are ordered by name in descending order.
     *
     * @param searchText the text to search for in the description field
     * @param pageable   the pagination information
     * @return a page of products matching the search criteria
     */
    @Query(value = "SELECT * FROM product WHERE description LIKE %?1% ORDER BY name DESC", nativeQuery = true)
    Page<Product> findAllWithSearchText(String searchText, Pageable pageable);

    /**
     * Counts the number of products whose description contains the given search text.
     *
     * @param searchText the text to search for in the description field
     * @return the count of products matching the search criteria
     */
    @Query(value = "SELECT COUNT(*) FROM product WHERE description LIKE %?1%", nativeQuery = true)
    long countAllWithSearchText(String searchText);
}