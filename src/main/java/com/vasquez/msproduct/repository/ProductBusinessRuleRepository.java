package com.vasquez.msproduct.repository;

import com.vasquez.msproduct.entity.ProductBusinessRule;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Product business rule repository.
 *
 * @author Vasquez
 * @version 1.0.0
 */
@Repository
public interface ProductBusinessRuleRepository extends ReactiveMongoRepository<ProductBusinessRule, String> {
}
