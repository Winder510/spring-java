package com.winder.service.impl;

import com.winder.base.AppException;
import com.winder.dto.request.authentication.AuthenticationRequest;
import com.winder.dto.response.AuthenticationResponse;
import com.winder.entity.user.UserEntity;
import com.winder.enums.ErrorCode;
import com.winder.mapper.UserMapper;
import com.winder.repository.UserRepository;
import com.winder.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    public boolean authenticate(AuthenticationRequest request) {
        UserEntity user = userRepository.findByUserName(request.getUsername()).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.matches(request.getPassword(), user.getUserPassword());
    }



}
