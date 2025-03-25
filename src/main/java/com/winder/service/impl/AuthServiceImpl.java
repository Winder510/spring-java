package com.winder.service.impl;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.winder.base.AppException;
import com.winder.dto.request.authentication.AuthenticationRequest;
import com.winder.dto.request.authentication.IntrospectRequest;
import com.winder.dto.response.AuthenticationResponse;
import com.winder.dto.response.IntrospectResponse;
import com.winder.entity.user.UserEntity;
import com.winder.enums.ErrorCode;
import com.winder.mapper.UserMapper;
import com.winder.repository.UserRepository;
import com.winder.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.ErrorManager;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Value("${jwt.secret}")
    @NonFinal
    private String jwtSecret;


    @Override
    public UserEntity signUp(String userName, String userPassword, String userEmail) {
        UserEntity user = new UserEntity();
        user.setUserPassword(userPassword);
        user.setUserEmail(userEmail);
        user.setUserName(userName);

        userRepository.save(user);

        return user;
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        UserEntity user = userRepository.findByUserName(request.getUsername()).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated =  passwordEncoder.matches(request.getPassword(), user.getUserPassword());

        if(!authenticated) throw new AppException(ErrorCode.UNAUTHENTICATED);

        var token = generateToken(request.getUsername());
        return AuthenticationResponse.builder()
                .token(token)
                .isAuthenticated(true)
                .build();

    }

    @Override
    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {
        var token = request.getToken();
        JWSVerifier jwsVerifier = new MACVerifier(jwtSecret.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        // check exprire time
        Date expireTime = signedJWT.getJWTClaimsSet().getExpirationTime();

       var verified =  signedJWT.verify(jwsVerifier);

       return IntrospectResponse.builder()
               .valid(verified && expireTime.after(new Date()))
               .build();

    }

    private String generateToken(String username){
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issuer("winder")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("Custom","Custom")
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(jwsHeader,payload);

        try {
            jwsObject.sign(new MACSigner(jwtSecret.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("Can not generate token",e);
            throw new RuntimeException(e);
        }


    }

}
