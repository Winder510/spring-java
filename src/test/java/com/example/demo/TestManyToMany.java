package com.example.demo;

import com.winder.MainApplication;
import com.winder.entity.OrderEntity;
import com.winder.entity.ProductEntity;
import com.winder.repository.OrderRepository;
import com.winder.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest(classes = MainApplication.class)
public class TestManyToMany {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Rollback(false)
    @Transactional
    void manyToManyInsertTest(){

        ProductEntity p1  = new ProductEntity();
        ProductEntity p2  = new ProductEntity();

        OrderEntity o1 = new OrderEntity();
        OrderEntity o2 = new OrderEntity();
        OrderEntity o3 = new OrderEntity();

        p1.setProductPrice(new BigDecimal(40));
        p1.setProductName("phong 1");

        p2.setProductPrice(new BigDecimal(10));
        p2.setProductName("phong 2");

        o1.setUserId("1");
        o2.setUserId("2");
        o3.setUserId("1");

        p1.setOrderList(List.of(o1,o2));
        p2.setOrderList(List.of(o1,o1,o2));


        productRepository.save(p1);
        productRepository.save(p2);


        orderRepository.save(o1);
        orderRepository.save(o2);
        orderRepository.save(o3);

    }
}
