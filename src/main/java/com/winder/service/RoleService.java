package com.winder.service;

import com.winder.dto.request.user.PermissionCreationRequest;
import com.winder.dto.request.user.RoleCreationRequest;
import com.winder.dto.response.PermissionResponse;
import com.winder.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {
    RoleResponse createRole(RoleCreationRequest request);
    RoleResponse getRoleById (Long id);
    List<RoleResponse>  getAllRole();
    void deleteRole(Long id);
}
