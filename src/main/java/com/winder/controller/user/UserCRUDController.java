package com.winder.controller.user;

import com.winder.dto.request.user.UserCreationRequest;
import com.winder.dto.response.ApiResponse;
import com.winder.entity.user.UserEntity;
import com.winder.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserCRUDController {

     UserService userService;

    @PostMapping("/add")
    public ApiResponse<UserEntity> addUser(@RequestBody @Valid UserCreationRequest userCreationRequest){
        ApiResponse<UserEntity> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(userCreationRequest));

        return apiResponse;
    }

    @GetMapping()
    public UserEntity getUser(@RequestParam Long id){
        return userService.getUser(id);
    }

    @GetMapping("/search")
    public UserEntity searchUser(@RequestParam String userName,@RequestParam String userEmail){
        return userService.findByUserNameAndUserEmail(userName,userEmail);
    }

    @GetMapping("/getAll")
    public Page<UserEntity> getAll(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ){
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection,sort);
        Pageable pageable = PageRequest.of(page,size,sortBy);
        return userService.findAllUsers(pageable);
    }

    @GetMapping("/searchPage")
    public Page<UserEntity> searchPageByUserName(
            @RequestParam String userName,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ){
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection,sort);
        Pageable pageable = PageRequest.of(page,size,sortBy);
        return userService.findByUserNameContaining(userName,pageable);
    }


}
