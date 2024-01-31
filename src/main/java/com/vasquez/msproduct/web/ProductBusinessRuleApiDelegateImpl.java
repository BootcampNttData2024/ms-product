package com.vasquez.msproduct.web;

import com.vasquez.msproduct.api.ProductBusinessRuleApiDelegate;
import com.vasquez.msproduct.model.ProductBusinessRuleRequest;
import com.vasquez.msproduct.model.ProductBusinessRuleResponse;

import com.vasquez.msproduct.service.ProductBusinessRuleService;
import com.vasquez.msproduct.web.mapper.ProductBusinessRuleMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductBusinessRuleApiDelegateImpl implements ProductBusinessRuleApiDelegate {

    private final ProductBusinessRuleService productBusinessRuleService;

    public ProductBusinessRuleApiDelegateImpl(ProductBusinessRuleService productBusinessRuleService) {
        this.productBusinessRuleService = productBusinessRuleService;
    }

    @Override
    public Mono<ProductBusinessRuleResponse> addProductBusinessRule(Mono<ProductBusinessRuleRequest> productBusinessRuleRequest, ServerWebExchange exchange) {
        return productBusinessRuleRequest.map(ProductBusinessRuleMapper::toEntity)
                .flatMap(productBusinessRuleService::create)
                .map(ProductBusinessRuleMapper::toResponse);
    }

    @Override
    public Mono<Void> deleteProductBusinessRuleById(String productBusinessRuleId, ServerWebExchange exchange) {
        return productBusinessRuleService.deleteById(productBusinessRuleId);
    }

    @Override
    public Mono<Flux<ProductBusinessRuleResponse>> getAllProductBusinessRule(ServerWebExchange exchange) {
        return Mono.just(productBusinessRuleService.findAll().map(ProductBusinessRuleMapper::toResponse));
    }

    @Override
    public Mono<ProductBusinessRuleResponse> getProductBusinessRuleById(String productBusinessRuleId, ServerWebExchange exchange) {
        return productBusinessRuleService.findById(productBusinessRuleId).map(ProductBusinessRuleMapper::toResponse);
    }

    @Override
    public Mono<ProductBusinessRuleResponse> updateProductBusinessRule(String productBusinessRuleId, Mono<ProductBusinessRuleRequest> productBusinessRuleRequest, ServerWebExchange exchange) {
        return productBusinessRuleRequest.map(ProductBusinessRuleMapper::toEntity)
                .flatMap(pro -> productBusinessRuleService.update(pro, productBusinessRuleId))
                .map(ProductBusinessRuleMapper::toResponse);
    }
}
