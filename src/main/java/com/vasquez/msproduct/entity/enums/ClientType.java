package com.vasquez.msproduct.entity.enums;

import lombok.Getter;

/**
 * Client type enum.
 *
 * @author Vasquez
 * @version 1.0.0
 */
@Getter
public enum ClientType {

  PERSONAL("PERSONAL"),
  BUSINESS("EMPRESARIAL");
  private String value;

  ClientType(String value) {
    this.value = value;
  }

}
