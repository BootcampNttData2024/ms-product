package com.vasquez.msproduct.service.impl;

import com.vasquez.msproduct.entity.ProductType;
import com.vasquez.msproduct.repository.ProductTypeRepository;

import com.vasquez.msproduct.service.ProductService;
import com.vasquez.msproduct.service.ProductTypeService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
