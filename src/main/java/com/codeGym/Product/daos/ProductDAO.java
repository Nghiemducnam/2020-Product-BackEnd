package com.codeGym.Product.daos;

import com.codeGym.Product.dtos.ProductDTO;

import java.util.List;

public interface ProductDAO {
    List<ProductDTO> getProducts(int limit);

    List<ProductDTO> getProductList();
}
