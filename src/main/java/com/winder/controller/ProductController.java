package com.winder.controller;

import com.winder.entity.ProductEntity;
import com.winder.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ProductEntity createProduct(ProductEntity productEntity){
        return productService.createProduct(productEntity);
    }
}
