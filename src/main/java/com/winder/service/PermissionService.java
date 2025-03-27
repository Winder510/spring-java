package com.winder.service;

import com.winder.dto.request.user.PermissionCreationRequest;
import com.winder.dto.response.PermissionResponse;
import com.winder.entity.ProductEntity;

import java.util.List;

public interface PermissionService {
    PermissionResponse createPermission(PermissionCreationRequest request);
    List<PermissionResponse> getListPermissions();
    void deletePermission(Long id);
}
