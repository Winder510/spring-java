package com.winder.service;

import com.winder.dto.request.authentication.AuthenticationRequest;
import com.winder.dto.response.AuthenticationResponse;
import com.winder.entity.user.UserEntity;
import org.springframework.stereotype.Service;

public interface AuthService {
    UserEntity signUp(String userName,String userPassword,String userEmail);
    boolean authenticate(AuthenticationRequest request);

}
