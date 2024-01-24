package com.vasquez.msproduct.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product_business_rule")
public class ProductBusinessRule {

    @Id
    private String productBusinessRuleId;

    @NotNull
    private String productId;

    @NotNull
    private String clientTypeId;

    @NotNull
    private Double maintenanceCommission;

    @NotNull
    private Integer maxHolders;

    @NotNull
    private Integer maxSignatories;

    @NotNull
    private Integer maxMovementsPerMonth;

    @NotNull
    private String dayMovementsPerMonth;

    @NotNull
    private Integer maxTransactionFree;

    @NotNull
    private boolean requiredAccount;

    @NotNull
    private Integer maxQuantityProduct;

}
