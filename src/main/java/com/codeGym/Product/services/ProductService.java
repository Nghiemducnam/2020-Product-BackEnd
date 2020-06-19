package com.codeGym.Product.services;

import com.codeGym.Product.dtos.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProducts(int limit);
}
