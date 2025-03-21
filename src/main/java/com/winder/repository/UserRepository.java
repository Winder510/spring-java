package com.winder.repository;

import com.winder.entity.user.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
//@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>, JpaSpecificationExecutor<UserEntity> {

    // use pageable
    Page<UserEntity> findByUserName(String userName, Pageable pageable);
    Page<UserEntity> findByUserNameContaining(String userName, Pageable pageable);

    UserEntity findByUserNameAndUserEmail(String userName,String userEmail);
    UserEntity findByUserNameAndUserPassword(String userName,String userPassord);
  //  UserEntity findByUserName(String userName);

    /**
     * where username like %?
     */
    List<UserEntity> findByUserNameStartingWith(String userName);


    /**
     * where username like ?%
     */
    List<UserEntity> findByUserNameEndingWith(String userName);

    /**
     * where id < 1
     */
    List<UserEntity> findByIdLessThan(Long id);

//    // Raw jpql
//    @Query("SELECT u FROM UserEntity WHERE u.id= (SELECT MAX(p.id) FROM UserEntity p")
//    UserEntity FindMaxIdUser();
//
//    @Query("SELECT u FROM UserEntity WHERE u.userName= ?1 AND u.userEmail = ?2")
//    List<UserEntity> getUserEntityList( String userName, String userEmail);
//
//    @Query("SELECT u FROM UserEntity WHERE u.userName= :userName AND u.userEmail = :email")
//    List<UserEntity> getUserEntityListByTwo(@Param("userName") String userName,@Param("userEmail") String email);
//
//
//    /**
//     * UPDATE DELETE
//     */
//
//    @Modifying
//    @Query("UPDATE UserEntity u SET u.userEmail= :userName")
//    @Transactional
//    int updateUserName(@Param("userEmail") String userName);
//
//    // native query
//    /**
//     * get user count by native query
//     */
//    @Query(value = "SELECT COUNT(id) FROM java_user_001",nativeQuery = true)
//    long getTotalUser();
}
