package com.vasquez.msproduct.service;

import com.vasquez.msproduct.entity.ProductType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Product type service.
 *
 * @author Vasquez
 * @version 1.0.0
 */
public interface ProductTypeService {

  Mono<ProductType> create(ProductType request);

  Mono<ProductType> update(ProductType request, String productTypeId);

  Mono<ProductType> findById(String productTypeId);

  Flux<ProductType> findAll();

  Mono<Void> deleteById(String productTypeId);

}
