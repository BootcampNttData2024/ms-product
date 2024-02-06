package com.vasquez.msproduct.repository;

import com.vasquez.msproduct.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Product repository.
 *
 * @author Vasquez
 * @version 1.0.0
 */
@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
