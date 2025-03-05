package com.winder.repository.impl;

import com.winder.entity.ProductEntity;
import com.winder.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public ProductEntity createProduct(ProductEntity product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setProductName("ve tau");
        productEntity.setProductPrice(new BigDecimal("21.3"));
        return null;
    }

    @Override
    public List<ProductEntity> findAllProduct() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setProductName("ve tau");
        productEntity.setProductPrice(new BigDecimal("21.3"));
        return List.of(productEntity);
    }
}
