package com.vasquez.msproduct.controller;

import com.vasquez.msproduct.api.ProductApi;
import com.vasquez.msproduct.model.ProductRequest;
import com.vasquez.msproduct.model.ProductResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductRestController implements ProductApi {
    @Override
    public Mono<ProductResponse> addProduct(Mono<ProductRequest> productRequest, ServerWebExchange exchange) {
        System.out.println("init...");
        productRequest.subscribe(p -> System.out.println("req:" + p));
        return Mono.just(new ProductResponse());
    }

    @Override
    public Mono<Void> deleteProductById(String productId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<Flux<ProductResponse>> getAllProducts(ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ProductResponse> getProductById(String productId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<ProductResponse> updateProduct(String productId, Mono<ProductRequest> productRequest, ServerWebExchange exchange) {
        return null;
    }
}
