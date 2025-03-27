package com.winder.service.impl;

import com.winder.base.AppException;
import com.winder.dto.request.user.PermissionCreationRequest;
import com.winder.dto.request.user.RoleCreationRequest;
import com.winder.dto.response.PermissionResponse;
import com.winder.dto.response.RoleResponse;
import com.winder.entity.user.PermissionEntity;
import com.winder.enums.ErrorCode;
import com.winder.mapper.PermissionMapper;
import com.winder.mapper.RoleMapper;
import com.winder.repository.PermissionRepository;
import com.winder.repository.RoleRepository;
import com.winder.service.PermissionService;
import com.winder.service.RoleService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    RoleMapper roleMapper;


    @Override
    public RoleResponse createRole(RoleCreationRequest request) {
        var role = roleMapper.toRole(request);
        var permissions = permissionRepository.findAllById(request.getPermissionIds());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    @Override
    public RoleResponse getRoleById(Long id) {
        var role = roleRepository.findById(id).orElseThrow(()-> new AppException(ErrorCode.ROLE_NOT_EXISTED));
        return roleMapper.toRoleResponse(role);
    }

    @Override
    public List<RoleResponse> getAllRole() {
        var roles = roleRepository.findAll();
        return roles.stream()
                .map(roleMapper::toRoleResponse).toList();
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }


}
