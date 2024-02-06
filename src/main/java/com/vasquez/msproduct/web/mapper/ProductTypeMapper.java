package com.vasquez.msproduct.web.mapper;

import com.vasquez.msproduct.entity.ProductType;
import com.vasquez.msproduct.model.ProductTypeRequest;
import com.vasquez.msproduct.model.ProductTypeResponse;
import org.springframework.beans.BeanUtils;

/**
 * Product type mapper.
 *
 * @author Vasquez
 * @version 1.0.0
 */
public class ProductTypeMapper {

  /**
   * To entity.
   *
   * @param productTypeRequest product type request
   * @return product type entity
   */
  public static ProductType toEntity(ProductTypeRequest productTypeRequest) {
    ProductType productType = new ProductType();
    BeanUtils.copyProperties(productTypeRequest, productType);
    return productType;
  }

  /**
   * To response.
   *
   * @param productType product type entity
   * @return product type response
   */
  public static ProductTypeResponse toResponse(ProductType productType) {
    ProductTypeResponse productTypeResponse = new ProductTypeResponse();
    BeanUtils.copyProperties(productType, productTypeResponse);
    return productTypeResponse;
  }

}
