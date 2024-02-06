package com.vasquez.msproduct.entity;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Product entity.
 *
 * @author Vasquez
 * @version 1.0.0
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product_type")
public class ProductType {

  @Id
  private String productTypeId;

  @NotNull
  private String name;

}
