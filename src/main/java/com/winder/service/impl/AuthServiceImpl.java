package com.winder.service.impl;

import com.winder.entity.user.UserEntity;
import com.winder.repository.UserRepository;
import com.winder.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity signUp(String userName, String userPassword, String userEmail) {
        UserEntity user = new UserEntity();
        user.setUserPassword(userPassword);
        user.setUserEmail(userEmail);
        user.setUserName(userName);

        userRepository.save(user);

        return user;
    }

    @Override
    public Boolean signIn(String userName, String userPassword) {
        return userRepository.findByUserNameAndUserPassword(userName, userPassword) != null;
    }

}
