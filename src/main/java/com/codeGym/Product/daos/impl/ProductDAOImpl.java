package com.codeGym.Product.daos.impl;

import com.codeGym.Product.daos.ProductDAO;
import com.codeGym.Product.dtos.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAOImpl extends AbstractBaseDAO implements ProductDAO {
    private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
    @Override
    public List<ProductDTO> getProducts(int limit) {
        StringBuilder sql = new StringBuilder();
        sql.append("select pr.product_id, ");
        sql.append("pr.product_name, ");
        sql.append("pr.provider, ");
        sql.append("pr.quantity ");
        sql.append("from product pr ");
        sql.append("where pr.product_name is not null ");
        sql.append("limit :p_limit ");
        Map<String, Object> parameter = Collections.singletonMap("p_limit", limit);
        return getNamedParameterJdbcTemplate().query(sql.toString(), parameter, BeanPropertyRowMapper.newInstance(ProductDTO.class));

    }

    @Override
    public List<ProductDTO> getProductList() {
        StringBuilder sql = new StringBuilder();
        sql.append("select pr.product_id, ");
        sql.append("pr.product_name, ");
        sql.append("pr.provider, ");
        sql.append("pr.quantity ");
        sql.append("from product pr ");
//        sql.append("where pr.product_name is not null ");
        return getNamedParameterJdbcTemplate().query(sql.toString(), BeanPropertyRowMapper.newInstance(ProductDTO.class));

    }
}
