package com.vasquez.msproduct.web;

import com.vasquez.msproduct.api.ProductTypeApiDelegate;
import com.vasquez.msproduct.model.ProductTypeRequest;
import com.vasquez.msproduct.model.ProductTypeResponse;
import com.vasquez.msproduct.service.ProductTypeService;
import com.vasquez.msproduct.web.mapper.ProductTypeMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ProductTypeApiDelegateImpl.java
 *
 * @author Vasquez
 * @version 1.0.0
 */
@Service
public class ProductTypeApiDelegateImpl implements ProductTypeApiDelegate {

  private final ProductTypeService productTypeService;

  public ProductTypeApiDelegateImpl(ProductTypeService productTypeService) {
    this.productTypeService = productTypeService;
  }

  @Override
  public Mono<ResponseEntity<ProductTypeResponse>> addProductType(Mono<ProductTypeRequest> productTypeRequest, ServerWebExchange exchange) {
    return productTypeRequest
      .map(ProductTypeMapper::toEntity)
      .flatMap(productTypeService::create)
      .map(ProductTypeMapper::toResponse)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Void>> deleteProductTypeById(String productTypeId, ServerWebExchange exchange) {
    return productTypeService.deleteById(productTypeId)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Flux<ProductTypeResponse>>> getAllProductType(ServerWebExchange exchange) {
    return Mono.just(productTypeService.findAll()
        .map(ProductTypeMapper::toResponse))
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<ProductTypeResponse>> getProductTypeById(String productTypeId, ServerWebExchange exchange) {
    return productTypeService.findById(productTypeId)
      .map(ProductTypeMapper::toResponse)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<ProductTypeResponse>> updateProductType(String productTypeId, Mono<ProductTypeRequest> productTypeRequest, ServerWebExchange exchange) {
    return productTypeRequest
      .map(ProductTypeMapper::toEntity)
      .flatMap(pro -> productTypeService.update(pro, productTypeId))
      .map(ProductTypeMapper::toResponse)
      .map(ResponseEntity::ok);
  }
}
