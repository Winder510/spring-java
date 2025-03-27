package com.winder.repository;

import com.winder.entity.user.PermissionEntity;
import com.winder.entity.user.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

//@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long>, JpaSpecificationExecutor<RoleEntity> {

}
