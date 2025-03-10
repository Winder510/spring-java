package com.winder.service;

import com.winder.entity.user.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity user);
    List<UserEntity> getListUser( )    ;
}
