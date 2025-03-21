package com.winder.service;

import com.winder.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    ProductEntity createProduct(ProductEntity product);

    List<ProductEntity> findAllProduct();
}
