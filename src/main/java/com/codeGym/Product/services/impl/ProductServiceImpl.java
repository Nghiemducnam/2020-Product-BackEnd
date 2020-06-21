package com.codeGym.Product.services.impl;

import com.codeGym.Product.daos.ProductDAO;
import com.codeGym.Product.dtos.ProductDTO;
import com.codeGym.Product.models.HttpResult;
import com.codeGym.Product.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<ProductDTO> getProductsByLimit(int limit) {
        logger.info("SERVICE for products:{}", limit);
        return productDAO.getProducts(limit);
    }

    @Override
    public HttpResult getProductList() {
        HttpResult<ProductDTO> res = new HttpResult<>();


        try {
            List<ProductDTO> products = productDAO.getProductList();

            res.setSuccess(true);
            res.setMessage("Xoá thành công!");
            res.setCode("00");
            res.setData(products);

            return res;

        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMessage(ex.getMessage());
            return null;
        }
    }
}
