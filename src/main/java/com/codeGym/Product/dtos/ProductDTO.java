package com.codeGym.Product.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
    private Long productId;
    private String productName;
    private String provider;
    private Integer quantity;
}
