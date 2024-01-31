package com.vasquez.msproduct.web.mapper;

import com.vasquez.msproduct.entity.ProductType;
import com.vasquez.msproduct.model.ProductTypeRequest;
import com.vasquez.msproduct.model.ProductTypeResponse;
import org.springframework.beans.BeanUtils;

public class ProductTypeMapper {

    public static ProductType toEntity(ProductTypeRequest productTypeRequest) {
        ProductType productType = new ProductType();
        BeanUtils.copyProperties(productTypeRequest, productType);
        return productType;
    }

    public static ProductTypeResponse toResponse(ProductType productType) {
        ProductTypeResponse productTypeResponse = new ProductTypeResponse();
        BeanUtils.copyProperties(productType, productTypeResponse);
        return productTypeResponse;
    }

}
