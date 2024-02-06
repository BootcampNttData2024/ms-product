package com.vasquez.msproduct.repository;

import com.vasquez.msproduct.entity.ProductType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Product type repository.
 *
 * @author Vasquez
 * @version 1.0.0
 */
@Repository
public interface ProductTypeRepository extends ReactiveMongoRepository<ProductType, String> {
}
