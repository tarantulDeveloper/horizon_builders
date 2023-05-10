package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.request.RefreshAccessTokenRequest;
import com.horizonbuilders.server.dto.response.LoginResponse;
import com.horizonbuilders.server.model.User;

public interface RefreshTokenService {
    String generateRefreshToken(User user);

    LoginResponse generateAccessTokenByRefreshToken(RefreshAccessTokenRequest request);
}
