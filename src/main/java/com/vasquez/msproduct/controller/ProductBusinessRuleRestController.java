package com.vasquez.msproduct.controller;

import com.vasquez.msproduct.api.ProductBusinessRuleApi;
import com.vasquez.msproduct.model.ProductBusinessRuleRequest;
import com.vasquez.msproduct.model.ProductBusinessRuleResponse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductBusinessRuleRestController implements ProductBusinessRuleApi {

    @Override
    public Mono<ProductBusinessRuleResponse> addProductBusinessRule(Mono<ProductBusinessRuleRequest> productBusinessRuleRequest, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<Void> deleteProductBusinessRuleById(String productBusinessRuleId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<Flux<ProductBusinessRuleResponse>> getAllProductBusinessRule(ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ProductBusinessRuleResponse> getProductBusinessRuleById(String productBusinessRuleId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ProductBusinessRuleResponse> updateProductBusinessRule(String productBusinessRuleId, Mono<ProductBusinessRuleRequest> productBusinessRuleRequest, ServerWebExchange exchange) {
        return null;
    }
}
