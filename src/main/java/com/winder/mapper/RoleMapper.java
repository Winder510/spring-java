package com.winder.mapper;


import com.winder.dto.request.user.PermissionCreationRequest;
import com.winder.dto.request.user.RoleCreationRequest;
import com.winder.dto.response.PermissionResponse;
import com.winder.dto.response.RoleResponse;
import com.winder.entity.user.PermissionEntity;
import com.winder.entity.user.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    RoleEntity toRole(RoleCreationRequest request);

    RoleResponse toRoleResponse(RoleEntity role);

}
