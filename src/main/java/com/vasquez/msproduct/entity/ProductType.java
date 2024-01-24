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
@Document(collection = "product_type")
public class ProductType {

    @Id
    private String productTypeId;

    @NotNull
    private String name;

}
