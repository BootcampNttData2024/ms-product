package com.vasquez.msproduct.controller;

import com.vasquez.msproduct.api.ProductTypeApi;
import com.vasquez.msproduct.model.ProductTypeRequest;
import com.vasquez.msproduct.model.ProductTypeResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductTypeRestController implements ProductTypeApi {

    @Override
    public Mono<ProductTypeResponse> addProductType(Mono<ProductTypeRequest> productTypeRequest, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<Void> deleteProductTypeById(String productTypeId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<Flux<ProductTypeResponse>> getAllProductType(ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ProductTypeResponse> getProductTypeById(String productTypeId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ProductTypeResponse> updateProductType(String productTypeId, Mono<ProductTypeRequest> productTypeRequest, ServerWebExchange exchange) {
        return null;
    }
}
