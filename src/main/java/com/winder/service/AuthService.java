package com.winder.service;

import com.nimbusds.jose.JOSEException;
import com.winder.dto.request.authentication.AuthenticationRequest;
import com.winder.dto.request.authentication.IntrospectRequest;
import com.winder.dto.response.AuthenticationResponse;
import com.winder.dto.response.IntrospectResponse;
import com.winder.entity.user.UserEntity;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;

public interface AuthService {


    UserEntity signUp(String userName,String userPassword,String userEmail);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;

}

