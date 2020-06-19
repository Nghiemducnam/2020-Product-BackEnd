package com.codeGym.Product.services.impl;

import com.codeGym.Product.daos.ProductDAO;
import com.codeGym.Product.dtos.ProductDTO;
import com.codeGym.Product.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<ProductDTO> getProducts(int limit) {
        logger.info("SERVICE for products:{}", limit);
        return productDAO.getProducts(limit);
    }
}
