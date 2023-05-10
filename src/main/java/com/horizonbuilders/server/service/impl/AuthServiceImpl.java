package com.horizonbuilders.server.service.impl;

import com.horizonbuilders.server.dto.response.LoginResponse;
import com.horizonbuilders.server.jwt.JwtUtils;
import com.horizonbuilders.server.model.User;
import com.horizonbuilders.server.service.AuthService;
import com.horizonbuilders.server.service.RefreshTokenService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {
    final AuthenticationManager authenticationManager;
    final JwtUtils jwtUtils;
    final RefreshTokenService refreshTokenService;

    @Override
    public LoginResponse authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                username, password
        );

        Authentication authentication = authenticationManager.authenticate(token);
        String accessToken = jwtUtils.generate(username);
        String refreshToken = refreshTokenService.generateRefreshToken((User) authentication.getPrincipal());

        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

    }
}
