package com.winder.service;

import com.winder.entity.user.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity user);
    List<UserEntity> getListUser();
    UserEntity findByUserNameAndUserEmail(String userName,String userEmail);

    // get all b limit offset
    Page<UserEntity> findAllUsers(Pageable pageable);

    //get search by limit offset
    Page<UserEntity> findByUserNameContaining(String userName, Pageable pageable);
}
