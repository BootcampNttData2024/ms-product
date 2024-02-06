package com.vasquez.msproduct.web.mapper;

import com.vasquez.msproduct.entity.Product;
import com.vasquez.msproduct.model.ProductRequest;
import com.vasquez.msproduct.model.ProductResponse;
import org.springframework.beans.BeanUtils;

/**
 * Product mapper.
 *
 * @author Vasquez
 * @version 1.0.0
 */
public class ProductMapper {

  /**
   * To entity.
   *
   * @param productRequest product request
   * @return product entity
   */
  public static Product toEntity(ProductRequest productRequest) {
    Product product = new Product();
    BeanUtils.copyProperties(productRequest, product);
    return product;
  }

  /**
   * To response.
   *
   * @param product product entity
   * @return product response
   */
  public static ProductResponse toResponse(Product product) {
    ProductResponse productResponse = new ProductResponse();
    BeanUtils.copyProperties(product, productResponse);
    return productResponse;
  }

}
