package com.vasquez.msproduct.web.mapper;

import com.vasquez.msproduct.entity.ProductBusinessRule;
import com.vasquez.msproduct.model.ProductBusinessRuleRequest;
import com.vasquez.msproduct.model.ProductBusinessRuleResponse;
import org.springframework.beans.BeanUtils;

/**
 * Product business rule mapper.
 *
 * @author Vasquez
 * @version 1.0.0
 */
public class ProductBusinessRuleMapper {

  /**
   * To entity.
   *
   * @param productBusinessRuleRequest product business rule request
   * @return product business rule entity
   */
  public static ProductBusinessRule toEntity(ProductBusinessRuleRequest productBusinessRuleRequest) {
    ProductBusinessRule productBusinessRule = new ProductBusinessRule();
    BeanUtils.copyProperties(productBusinessRuleRequest, productBusinessRule);
    return productBusinessRule;
  }

  /**
   * To response.
   *
   * @param productBusinessRule product business rule entity
   * @return product business rule response
   */
  public static ProductBusinessRuleResponse toResponse(ProductBusinessRule productBusinessRule) {
    ProductBusinessRuleResponse productBusinessRuleResponse = new ProductBusinessRuleResponse();
    BeanUtils.copyProperties(productBusinessRule, productBusinessRuleResponse);
    return productBusinessRuleResponse;
  }

}
