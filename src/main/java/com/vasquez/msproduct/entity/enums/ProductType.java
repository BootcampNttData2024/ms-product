package com.vasquez.msproduct.entity.enums;

import lombok.Getter;

/**
 * Product type enum.
 *
 * @author Vasquez
 * @version 1.0.0
 */
@Getter
public enum ProductType {
  SAVING_ACCOUNT("CUENTA DE AHORROS"),
  CURRENT_ACCOUNT("CUENTA CORRIENTE"),
  FIXED_TERM_ACCOUNT("CUENTA A PLAZO FIJO"),
  CREDIT("CREDITO");
  private String value;

  ProductType(String value) {
    this.value = value;
  }

}
