package com.winder.controller.user;

import com.winder.dto.request.authentication.AuthenticationRequest;
import com.winder.dto.response.ApiResponse;
import com.winder.dto.response.AuthenticationResponse;
import com.winder.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserAuthController {
     AuthService authService;

    @PostMapping("/sign-in")
    public ApiResponse<AuthenticationResponse> signIn(@RequestBody AuthenticationRequest request){
        return ApiResponse.<AuthenticationResponse>builder()
                .result(AuthenticationResponse.builder()
                        .isAuthenticated(authService.authenticate(request))
                        .build())
                .build();
    }
}
