package com.vasquez.msproduct.service.impl;

import com.vasquez.msproduct.entity.Product;
import com.vasquez.msproduct.repository.ProductRepository;
import com.vasquez.msproduct.service.ProductService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Product service implementation.
 *
 * @author Vasquez
 * @version 1.0.0
 */
@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Mono<Product> create(Product request) {
    return productRepository.save(request);
  }

  @Override
  public Mono<Product> update(Product request, String id) {
    return this.findById(id).flatMap(pro -> {
      pro.setProductTypeId(request.getProductTypeId());
      pro.setName(request.getName());
      return productRepository.save(pro);
    });
  }

  @Override
  public Mono<Product> findById(String id) {
    return productRepository.findById(id);
  }

  @Override
  public Flux<Product> findAll() {
    return productRepository.findAll();
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return productRepository.deleteById(id);
  }
}
