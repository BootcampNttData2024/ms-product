package com.vasquez.msproduct.entity.enums;

import lombok.Getter;


/**
 * Profile type enum.
 *
 * @author Vasquez
 * @version 1.0.0
 */
@Getter
public enum ProfileType {

  VIP("VIP"),
  PYME("PYME");
  private String value;

  ProfileType(String value) {
    this.value = value;
  }

}
