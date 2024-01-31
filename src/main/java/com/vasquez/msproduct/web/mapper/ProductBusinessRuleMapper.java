package com.vasquez.msproduct.web.mapper;

import com.vasquez.msproduct.entity.ProductBusinessRule;
import com.vasquez.msproduct.model.ProductBusinessRuleRequest;
import com.vasquez.msproduct.model.ProductBusinessRuleResponse;
import org.springframework.beans.BeanUtils;

public class ProductBusinessRuleMapper {

    public static ProductBusinessRule toEntity(ProductBusinessRuleRequest productBusinessRuleRequest) {
        ProductBusinessRule productBusinessRule = new ProductBusinessRule();
        BeanUtils.copyProperties(productBusinessRuleRequest, productBusinessRule);
        return productBusinessRule;
    }

    public static ProductBusinessRuleResponse toResponse(ProductBusinessRule productBusinessRule) {
        ProductBusinessRuleResponse productBusinessRuleResponse = new ProductBusinessRuleResponse();
        BeanUtils.copyProperties(productBusinessRule, productBusinessRuleResponse);
        return productBusinessRuleResponse;
    }

}
