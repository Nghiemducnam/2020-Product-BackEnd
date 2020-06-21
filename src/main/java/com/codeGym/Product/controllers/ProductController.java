package com.codeGym.Product.controllers;

import com.codeGym.Product.dtos.ProductDTO;
import com.codeGym.Product.models.HttpResult;
import com.codeGym.Product.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{topN}")
    public ResponseEntity<List<ProductDTO>> getProducts(@PathVariable Integer topN) {
        logger.info("REST to request get top company:{}", topN);
        if (topN <= 0 || topN >= 20){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productService.getProductsByLimit(topN), HttpStatus.OK);
    }

    @GetMapping("/productList")
    public ResponseEntity<?> getProductList() {
        logger.info("REST to request get top company:{}");
        HttpResult<ProductDTO> products =  productService.getProductList();
//        List<ProductDTO> products = productService.getProductList();
        if (products == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}



