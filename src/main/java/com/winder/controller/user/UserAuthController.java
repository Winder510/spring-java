package com.winder.controller.user;

import com.nimbusds.jose.JOSEException;
import com.winder.dto.request.authentication.AuthenticationRequest;
import com.winder.dto.request.authentication.IntrospectRequest;
import com.winder.dto.response.ApiResponse;
import com.winder.dto.response.AuthenticationResponse;
import com.winder.dto.response.IntrospectResponse;
import com.winder.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/v1/api/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserAuthController {
     AuthService authService;

    @PostMapping("/sign-in")
    public ApiResponse<AuthenticationResponse> signIn(@RequestBody AuthenticationRequest request){
        return ApiResponse.<AuthenticationResponse>builder()
                .result(authService.authenticate(request))
                .build();
    }

    @PostMapping("/introspect")
    public ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        return ApiResponse.<IntrospectResponse>builder()
                .result(authService.introspect(request))
                .build();
    }
}
