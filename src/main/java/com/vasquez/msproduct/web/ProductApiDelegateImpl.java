package com.vasquez.msproduct.web;

import com.vasquez.msproduct.api.ProductApiDelegate;
import com.vasquez.msproduct.model.ProductRequest;
import com.vasquez.msproduct.model.ProductResponse;
import com.vasquez.msproduct.service.ProductService;
import com.vasquez.msproduct.service.impl.ProductTypeServiceImpl;
import com.vasquez.msproduct.web.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductApiDelegateImpl implements ProductApiDelegate {

    private final ProductService productService;

    public ProductApiDelegateImpl(ProductService productService, ProductTypeServiceImpl productTypeService) {
        this.productService = productService;
    }

    @Override
    public Mono<ProductResponse> addProduct(Mono<ProductRequest> productRequest, ServerWebExchange exchange) {
        return productRequest.map(ProductMapper::toEntity)
                .flatMap(productService::create)
                .map(ProductMapper::toResponse);
    }

    @Override
    public Mono<Void> deleteProductById(String productId, ServerWebExchange exchange) {
        return productService.deleteById(productId);
    }

    @Override
    public Mono<Flux<ProductResponse>> getAllProducts(ServerWebExchange exchange) {
        return Mono.just(productService.findAll().map(ProductMapper::toResponse));
    }

    @Override
    public Mono<ProductResponse> getProductById(String productId, ServerWebExchange exchange) {
        return productService.findById(productId).map(ProductMapper::toResponse);
    }

    @Override
    public Mono<ProductResponse> updateProduct(String productId, Mono<ProductRequest> productRequest, ServerWebExchange exchange) {
        return productRequest.map(ProductMapper::toEntity)
                .flatMap( pro -> productService.update(pro, productId))
                .map(ProductMapper::toResponse);
    }
}
