package com.winder.service.impl;

import com.winder.dto.request.user.PermissionCreationRequest;
import com.winder.dto.response.PermissionResponse;
import com.winder.entity.user.PermissionEntity;
import com.winder.mapper.PermissionMapper;
import com.winder.repository.PermissionRepository;
import com.winder.service.PermissionService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public PermissionResponse createPermission(PermissionCreationRequest request) {
        PermissionEntity permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    @Override
    public List<PermissionResponse> getListPermissions() {
        var permissions = permissionRepository.findAll();
        return permissions.stream().map((value)-> permissionMapper.toPermissionResponse(value)).toList();
    }

    @Override
    public void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }


}
