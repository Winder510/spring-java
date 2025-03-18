package com.winder.repository;

import com.winder.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

//@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
//@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long>, JpaSpecificationExecutor<OrderEntity> {

}
