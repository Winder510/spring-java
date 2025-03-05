package com.winder.service.impl;

import com.winder.entity.ProductEntity;
import com.winder.repository.ProductRepository;
import com.winder.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    @Override
    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.createProduct(product);
    }

    @Override
    public List<ProductEntity> findAllProduct() {
        return productRepository.findAllProduct();
    }
}
