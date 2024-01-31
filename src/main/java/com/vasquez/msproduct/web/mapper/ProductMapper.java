package com.vasquez.msproduct.web.mapper;

import com.vasquez.msproduct.entity.Product;
import com.vasquez.msproduct.model.ProductRequest;
import com.vasquez.msproduct.model.ProductResponse;
import org.springframework.beans.BeanUtils;

public class ProductMapper {

    public static Product toEntity(ProductRequest productRequest) {
        Product product = new Product();
        BeanUtils.copyProperties(productRequest, product);
        return product;
    }

    public static ProductResponse toResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }

}
