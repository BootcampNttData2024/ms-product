package com.vasquez.msproduct.service.impl;

import com.vasquez.msproduct.entity.Product;
import com.vasquez.msproduct.entity.ProductBusinessRule;
import com.vasquez.msproduct.entity.enums.ProfileType;
import com.vasquez.msproduct.entity.enums.ClientType;
import com.vasquez.msproduct.entity.enums.ProductType;
import com.vasquez.msproduct.repository.ProductBusinessRuleRepository;
import com.vasquez.msproduct.service.ProductBusinessRuleService;
import com.vasquez.msproduct.service.exception.AppException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductBusinessRuleServiceImpl implements ProductBusinessRuleService {

    private final ProductBusinessRuleRepository productBusinessRuleRepository;
    private final ProductServiceImpl productService;

    public ProductBusinessRuleServiceImpl(ProductBusinessRuleRepository productBusinessRuleRepository, ProductServiceImpl productService) {
        this.productBusinessRuleRepository = productBusinessRuleRepository;
        this.productService = productService;
    }

    @Override
    public Mono<ProductBusinessRule> create(ProductBusinessRule request) {
        return productService.findById(request.getProductId())
                .switchIfEmpty(Mono.error(AppException.notFound("The productId not found")))
                .flatMap(product -> {
                    request.setMaxTransactionFree("20");
                    request.setCommissionPerTransaction(5D);
                    if (ClientType.PERSONAL.getValue().equals(request.getClientType())) {
                        //client profile VIP
                        if (!request.getProfileType().isEmpty()) {
                            if (request.getProfileType().equals(ProfileType.VIP.getValue()) &&
                                    ProductType.SAVING_ACCOUNT.getValue().equals(product.getName())) {
                                request.setMinMonthlyAmount(500.0);
                                request.setRequiredCreditCard(true);
                            } else return Mono.error(AppException
                                    .badRequest("The profile " + request.getProfileType() + " is invalid"
                                    + " or the product " + product.getName() + " is not available for the profile."));
                        }
                        //client normal
                        this.setBusinessRuleOfTypePersonal(request, product);
                    }
                    if (ClientType.BUSINESS.getValue().equals(request.getClientType())) {
                        //client profile PYME
                        if (!request.getProfileType().isEmpty()) {
                            if (request.getProfileType().equals(ProfileType.PYME.getValue()) &&
                                    ProductType.CURRENT_ACCOUNT.getValue().equals(product.getName())) {
                                request.setRequiredCurrentAccount(true);
                                request.setRequiredCreditCard(true);
                            } else
                                return Mono.error(AppException
                                        .badRequest("The profile " + request.getProfileType() + " is invalid"
                                        + " or the product " + product.getName() + " is not available for the profile."));
                        }
                        //client normal
                        if (ProductType.CURRENT_ACCOUNT.getValue().equals(product.getName()) ||
                                ProductType.CREDIT.getValue().equals(product.getName()))
                            this.setBusinessRuleOfTypeBusiness(request);
                        else return Mono.error(AppException
                                .badRequest("The product " + product.getName() + " is not available for BUSINESS client type"));
                    }
                    return productBusinessRuleRepository.save(request);
                });
    }

    @Override
    public Mono<ProductBusinessRule> update(ProductBusinessRule request, String id) {
        return this.findById(id).flatMap(prodBusRule -> {
            prodBusRule.setMaintenanceCommission(request.getMaintenanceCommission());
            prodBusRule.setMinHolders(request.getMinHolders());
            prodBusRule.setMinSignatories(request.getMinSignatories());
            prodBusRule.setMaxMovementsPerMonth(request.getMaxMovementsPerMonth());
            prodBusRule.setDayMovementsPerMonth(request.getDayMovementsPerMonth());
            prodBusRule.setMaxTransactionFree(request.getMaxTransactionFree());
            prodBusRule.setRequiredCurrentAccount(request.isRequiredCurrentAccount());
            return productBusinessRuleRepository.save(prodBusRule);
        });
    }

    @Override
    public Mono<ProductBusinessRule> findById(String id) {
        return productBusinessRuleRepository.findById(id);
    }

    @Override
    public Flux<ProductBusinessRule> findAll() {
        return productBusinessRuleRepository.findAll();
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return productBusinessRuleRepository.deleteById(id);
    }

    private void setBusinessRuleOfTypePersonal(ProductBusinessRule request, Product product) {
        if (ProductType.SAVING_ACCOUNT.getValue().equals(product.getName())) {
            request.setMaintenanceCommission(0.0);
            request.setMaxMovementsPerMonth("30");
        }
        if (ProductType.CURRENT_ACCOUNT.getValue().equals(product.getName())) {
            request.setMaintenanceCommission(5.0);
            request.setMaxMovementsPerMonth("UNLIMITED");
        }
        if (ProductType.FIXED_TERM_ACCOUNT.getValue().equals(product.getName())) {
            request.setMaintenanceCommission(0.0);
            request.setMaxMovementsPerMonth("1");
            request.setDayMovementsPerMonth("MONDAY");
        }
        request.setMaxSavingAccounts("1");
        request.setMaxCurrentAccounts("1");
        request.setMaxFixedTermAccounts("UNLIMITED");
        request.setMaxCredits("1");
    }

    private void setBusinessRuleOfTypeBusiness(ProductBusinessRule request) {
        request.setMaintenanceCommission(5.0);
        request.setMaxMovementsPerMonth("UNLIMITED");
        request.setMaxCurrentAccounts("UNLIMITED");
        request.setMaxSavingAccounts("0");
        request.setMaxFixedTermAccounts("0");
        request.setMinHolders(1);
        request.setMinSignatories(0);
        request.setMaxCredits("UNLIMITED");
        if (request.getProfileType().equals(ProfileType.PYME.getValue())) {
        }
    }

}
