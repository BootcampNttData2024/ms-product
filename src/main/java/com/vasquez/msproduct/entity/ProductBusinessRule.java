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
    private String clientType;

    private String profileType;

    private Double maintenanceCommission;

    private Integer minHolders;

    private Integer minSignatories;

    private String maxMovementsPerMonth;

    private String dayMovementsPerMonth;

    private String maxSavingAccounts;

    private String maxCurrentAccounts;

    private String maxFixedTermAccounts;

    private String maxCredits;

    private Double minMonthlyAmount;

    private boolean requiredCreditCard;

    private boolean requiredCurrentAccount;

    private String maxTransactionFree;

    private Double commissionPerTransaction;

}
