package com.winder.controller.user;

import com.winder.entity.user.UserEntity;
import com.winder.service.AuthService;
import com.winder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/auth")
public class UserAuthController {
    @Autowired
    private AuthService authService;

//    @PostMapping("/sign-in")
//    public UserEntity signIn(@RequestBody UserEntity userEntity){
//        return authService.signIn(userEntity);
//    }
}
