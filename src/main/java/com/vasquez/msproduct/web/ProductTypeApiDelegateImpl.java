package com.vasquez.msproduct.web;

import com.vasquez.msproduct.api.ProductTypeApiDelegate;
import com.vasquez.msproduct.model.ProductTypeRequest;
import com.vasquez.msproduct.model.ProductTypeResponse;
import com.vasquez.msproduct.service.ProductTypeService;
import com.vasquez.msproduct.web.mapper.ProductTypeMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductTypeApiDelegateImpl implements ProductTypeApiDelegate {

    private final ProductTypeService productTypeService;

    public ProductTypeApiDelegateImpl(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @Override
    public Mono<ProductTypeResponse> addProductType(Mono<ProductTypeRequest> productTypeRequest, ServerWebExchange exchange) {
        return productTypeRequest.map(ProductTypeMapper::toEntity)
                .flatMap(productTypeService::create)
                .map(ProductTypeMapper::toResponse);
    }

    @Override
    public Mono<Void> deleteProductTypeById(String productTypeId, ServerWebExchange exchange) {
        return productTypeService.deleteById(productTypeId);
    }

    @Override
    public Mono<Flux<ProductTypeResponse>> getAllProductType(ServerWebExchange exchange) {
        return Mono.just(productTypeService.findAll().map(ProductTypeMapper::toResponse));
    }

    @Override
    public Mono<ProductTypeResponse> getProductTypeById(String productTypeId, ServerWebExchange exchange) {
        return productTypeService.findById(productTypeId).map(ProductTypeMapper::toResponse);
    }

    @Override
    public Mono<ProductTypeResponse> updateProductType(String productTypeId, Mono<ProductTypeRequest> productTypeRequest, ServerWebExchange exchange) {
        return productTypeRequest.map(ProductTypeMapper::toEntity)
                .flatMap(pro -> productTypeService.update(pro, productTypeId))
                .map(ProductTypeMapper::toResponse);
    }
}
