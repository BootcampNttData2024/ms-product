package com.vasquez.msproduct.service;

import com.vasquez.msproduct.entity.ProductBusinessRule;
import com.vasquez.msproduct.repository.ProductBusinessRuleRepository;
import com.vasquez.msproduct.util.CrudUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductBusinessRuleService implements CrudUtil<ProductBusinessRule, String> {

    private final ProductBusinessRuleRepository productBusinessRuleRepository;

    public ProductBusinessRuleService(ProductBusinessRuleRepository productBusinessRuleRepository) {
        this.productBusinessRuleRepository = productBusinessRuleRepository;
    }

    @Override
    public Mono<ProductBusinessRule> create(ProductBusinessRule request) {
        return productBusinessRuleRepository.save(request);
    }

    @Override
    public Mono<ProductBusinessRule> update(ProductBusinessRule request, String id) {
        return productBusinessRuleRepository.save(request);
    }

    @Override
    public Mono<ProductBusinessRule> findById(String id) {
        return productBusinessRuleRepository.findById(id);
    }

    @Override
    public Flux<ProductBusinessRule> findAll() {
        return productBusinessRuleRepository.findAll();
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return productBusinessRuleRepository.deleteById(id);
    }
}
