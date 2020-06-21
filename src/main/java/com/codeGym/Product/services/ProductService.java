package com.codeGym.Product.services;

import com.codeGym.Product.dtos.ProductDTO;
import com.codeGym.Product.models.HttpResult;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProductsByLimit(int limit);

    HttpResult getProductList();
}
