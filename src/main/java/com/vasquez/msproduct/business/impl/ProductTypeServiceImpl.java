package com.vasquez.msproduct.business.impl;

import com.vasquez.msproduct.entity.ProductType;
import com.vasquez.msproduct.repository.ProductTypeRepository;
import com.vasquez.msproduct.business.ProductTypeService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Product type service implementation.
 *
 * @author Vasquez
 * @version 1.0.0
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

  private final ProductTypeRepository productTypeRepository;

  public ProductTypeServiceImpl(ProductTypeRepository productTypeRepository) {
    this.productTypeRepository = productTypeRepository;
  }

  @Override
  public Mono<ProductType> create(ProductType request) {
    return productTypeRepository.save(request);
  }

  @Override
  public Mono<ProductType> update(ProductType request, String id) {
    return this.findById(id).flatMap(productType -> {
      productType.setName(request.getName());
      return productTypeRepository.save(productType);
    });
  }

  @Override
  public Mono<ProductType> findById(String id) {
    return productTypeRepository.findById(id);
  }

  @Override
  public Flux<ProductType> findAll() {
    return productTypeRepository.findAll();
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return productTypeRepository.deleteById(id);
  }
}
