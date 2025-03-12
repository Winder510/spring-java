package com.winder.controller.user;

import com.winder.entity.user.UserEntity;
import com.winder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/user")
public class UserCRUDController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public UserEntity addUser(@RequestBody UserEntity userEntity){
        return userService.createUser(userEntity);
    }

    @GetMapping("/search")
        public UserEntity searchUser(@RequestParam String userName,@RequestParam String userEmail){
        return userService.findByUserNameAndUserEmail(userName,userEmail);
    }
}
