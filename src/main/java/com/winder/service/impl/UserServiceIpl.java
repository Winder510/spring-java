package com.winder.service.impl;

import com.winder.base.AppException;
import com.winder.dto.request.user.UserCreationRequest;
import com.winder.entity.user.UserEntity;
import com.winder.enums.ErrorCode;
import com.winder.mapper.UserMapper;
import com.winder.repository.UserRepository;
import com.winder.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceIpl.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserEntity createUser(UserCreationRequest req) {
        Boolean existed = userRepository.existsByUserEmail(req.getUserEmail());
        if(existed)  throw new RuntimeException("Email has been existed");

        UserEntity user = userMapper.toUser(req);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setUserPassword(passwordEncoder.encode(req.getUserPassword()));

        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getListUser() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findByUserNameAndUserEmail(String userName, String userEmail) {
        return userRepository.findByUserNameAndUserEmail(userName,userEmail);
    }

    @Override
    public Page<UserEntity> findAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }


    @Override
    public Page<UserEntity> findByUserNameContaining(String userName, Pageable pageable) {
        return userRepository.findByUserNameContaining(userName,pageable);
    }

    @Override
    @PostAuthorize("returnObject.userName == authentication.name")
    public UserEntity getUser(Long id) {
        var contextHolder = SecurityContextHolder.getContext();
        log.info("Authentication details: {}", contextHolder.getAuthentication().getName());

        return userRepository.findById(id).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));
    }


}
