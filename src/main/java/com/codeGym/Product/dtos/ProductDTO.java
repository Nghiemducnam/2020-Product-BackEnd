package com.codeGym.Product.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    private Long productId;
    private String productName;
    private String provider;
    private Integer quantity;
}
