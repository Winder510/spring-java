package com.winder.repository;

import com.winder.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    ProductEntity createProduct(ProductEntity product);

    List<ProductEntity> findAllProduct();

}
