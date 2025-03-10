package com.winder.service.impl;

import com.winder.entity.user.UserEntity;
import com.winder.repository.UserRepository;
import com.winder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceIpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getListUser() {
        return userRepository.findAll();
    }
}
