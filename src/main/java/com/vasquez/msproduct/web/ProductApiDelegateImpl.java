package com.vasquez.msproduct.web;

import com.vasquez.msproduct.api.ProductApiDelegate;
import com.vasquez.msproduct.model.ProductRequest;
import com.vasquez.msproduct.model.ProductResponse;
import com.vasquez.msproduct.business.ProductService;
import com.vasquez.msproduct.business.impl.ProductTypeServiceImpl;
import com.vasquez.msproduct.web.mapper.ProductMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ProductApiDelegateImpl.java
 *
 * @author Vasquez
 * @version 1.0.0
 */
@Service
public class ProductApiDelegateImpl implements ProductApiDelegate {

  private final ProductService productService;

  public ProductApiDelegateImpl(ProductService productService, ProductTypeServiceImpl productTypeService) {
    this.productService = productService;
  }

  @Override
  public Mono<ResponseEntity<ProductResponse>> addProduct(Mono<ProductRequest> productRequest, ServerWebExchange exchange) {
    return productRequest
      .map(ProductMapper::toEntity)
      .flatMap(productService::create)
      .map(ProductMapper::toResponse)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Void>> deleteProductById(String productId, ServerWebExchange exchange) {
    return productService.deleteById(productId)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Flux<ProductResponse>>> getAllProducts(ServerWebExchange exchange) {
    return Mono.just(productService.findAll()
        .map(ProductMapper::toResponse))
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<ProductResponse>> getProductById(String productId, ServerWebExchange exchange) {
    return productService.findById(productId)
      .map(ProductMapper::toResponse)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<ProductResponse>> updateProduct(String productId, Mono<ProductRequest> productRequest, ServerWebExchange exchange) {
    return productRequest
      .map(ProductMapper::toEntity)
      .flatMap(pro -> productService.update(pro, productId))
      .map(ProductMapper::toResponse)
      .map(ResponseEntity::ok);
  }
}
