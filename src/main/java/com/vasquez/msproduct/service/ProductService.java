package com.vasquez.msproduct.service;

import com.vasquez.msproduct.entity.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Product service.
 *
 * @author Vasquez
 * @version 1.0.0
 */
public interface ProductService {

  Mono<Product> create(Product request);

  Mono<Product> update(Product request, String productId);

  Mono<Product> findById(String productId);

  Flux<Product> findAll();

  Mono<Void> deleteById(String productId);

}
