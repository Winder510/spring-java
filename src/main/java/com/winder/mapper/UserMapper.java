package com.winder.mapper;


import com.winder.dto.request.user.UserCreationRequest;
import com.winder.dto.request.user.UserUpdateRequest;
import com.winder.entity.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toUser(UserCreationRequest request);
    void updateUser(@MappingTarget UserEntity user, UserUpdateRequest request);

}
