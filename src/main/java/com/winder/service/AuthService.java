package com.winder.service;

import com.winder.entity.user.UserEntity;
import org.springframework.stereotype.Service;

public interface AuthService {
    UserEntity signUp(String userName,String userPassword,String userEmail);
    Boolean signIn(String userName, String userPassword);

}
