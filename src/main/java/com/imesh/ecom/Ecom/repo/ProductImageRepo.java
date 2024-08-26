package com.imesh.ecom.Ecom.repo;

import com.imesh.ecom.Ecom.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProductImageRepo is a repository interface for managing ProductImage entities.
 * It extends JpaRepository to provide CRUD operations and custom query methods.
 */
public interface ProductImageRepo extends JpaRepository<ProductImage, String> {
}