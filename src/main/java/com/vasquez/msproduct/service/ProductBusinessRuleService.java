package com.vasquez.msproduct.service;

import com.vasquez.msproduct.entity.ProductBusinessRule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductBusinessRuleService {

    Mono<ProductBusinessRule> create(ProductBusinessRule request);

    Mono<ProductBusinessRule> update(ProductBusinessRule request, String productBusinessRuleId);

    Mono<ProductBusinessRule> findById(String productBusinessRuleId);

    Flux<ProductBusinessRule> findAll();

    Mono<Void> deleteById(String productBusinessRuleId);

}
