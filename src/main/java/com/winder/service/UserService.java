package com.winder.service;

import com.winder.entity.user.UserEntity;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity user);
    List<UserEntity> getListUser();
    UserEntity findByUserNameAndUserEmail(String userName,String userEmail);
}
