package com.vasquez.msproduct.service;

import com.vasquez.msproduct.entity.Product;
import com.vasquez.msproduct.repository.ProductRepository;
import com.vasquez.msproduct.util.CrudUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService implements CrudUtil<Product, String> {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Mono<Product> create(Product request) {
        return productRepository.save(request);
    }

    @Override
    public Mono<Product> update(Product request, String id) {
        return productRepository.save(request);
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
