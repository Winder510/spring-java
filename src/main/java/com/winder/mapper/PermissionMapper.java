package com.winder.mapper;


import com.winder.dto.request.user.PermissionCreationRequest;
import com.winder.dto.response.PermissionResponse;
import com.winder.entity.user.PermissionEntity;
import com.winder.entity.user.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    PermissionEntity toPermission(PermissionCreationRequest request);
    PermissionResponse toPermissionResponse(PermissionEntity permission);

}
