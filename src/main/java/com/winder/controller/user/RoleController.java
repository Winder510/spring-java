package com.winder.controller.user;

import com.winder.dto.request.user.PermissionCreationRequest;
import com.winder.dto.request.user.RoleCreationRequest;
import com.winder.dto.response.ApiResponse;
import com.winder.dto.response.PermissionResponse;
import com.winder.dto.response.RoleResponse;
import com.winder.service.PermissionService;
import com.winder.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Slf4j
public class RoleController {
    RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> create(@RequestBody RoleCreationRequest request){
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.createRole(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> getAll(){
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getAllRole())
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<Void> delete(@PathVariable Long id){
        roleService.deleteRole(id);
        return ApiResponse.<Void>builder().build();
    }
}
