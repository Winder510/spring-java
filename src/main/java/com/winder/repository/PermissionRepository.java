package com.winder.repository;

import com.winder.entity.OrderEntity;
import com.winder.entity.user.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

//@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity,Long>, JpaSpecificationExecutor<PermissionEntity> {

}
