package com.winder.service.impl;

import com.winder.dto.request.user.UserCreationRequest;
import com.winder.entity.user.UserEntity;
import com.winder.mapper.UserMapper;
import com.winder.repository.UserRepository;
import com.winder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceIpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserEntity createUser(UserCreationRequest req) {
        Boolean existed = userRepository.existsByUserEmail(req.getUserEmail());
        if(existed)  throw new RuntimeException("Email has been existed");

        UserEntity user = userMapper.toUser(req);

//        UserEntity user = new UserEntity();
//        user.setUserName(req.getUserName());
//        user.setUserPassword(req.getUserPassword());
//        user.setUserEmail(req.getUserEmail());

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
    public UserEntity getUser(Long id) {
       return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }


}
