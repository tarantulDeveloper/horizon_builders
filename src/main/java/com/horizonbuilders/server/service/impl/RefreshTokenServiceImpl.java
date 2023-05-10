package com.horizonbuilders.server.service.impl;

import com.horizonbuilders.server.dto.request.RefreshAccessTokenRequest;
import com.horizonbuilders.server.dto.response.LoginResponse;
import com.horizonbuilders.server.exception.ResourceNotFoundException;
import com.horizonbuilders.server.exception.UnauthorizedException;
import com.horizonbuilders.server.exception.UserNotFoundException;
import com.horizonbuilders.server.jwt.JwtUtils;
import com.horizonbuilders.server.model.RefreshToken;
import com.horizonbuilders.server.model.User;
import com.horizonbuilders.server.repository.RefreshTokenRepository;
import com.horizonbuilders.server.service.RefreshTokenService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefreshTokenServiceImpl implements RefreshTokenService {
    final RefreshTokenRepository refreshTokenRepository;
    final JwtUtils jwtUtils;

    @Value("${jwt_refresh_token_expiration_in_hours}")
    long jwt_refresh_token_expiration_in_hours;

    @Override
    public String generateRefreshToken(User user) {

        RefreshToken refreshToken = null;
        if (refreshTokenRepository.existsByUser(user)) {
            refreshToken = refreshTokenRepository.findByUser(user)
                    .orElseThrow(UserNotFoundException::new);
            refreshTokenRepository.delete(refreshToken);
        }
        refreshToken = generateCompleteNewRefreshToken(user);
        return refreshToken.getRefreshToken();
    }

    @Override
    public LoginResponse generateAccessTokenByRefreshToken(RefreshAccessTokenRequest request) {

        RefreshToken refreshToken = refreshTokenRepository.findByRefreshToken(request.refreshToken())
                .orElseThrow(() -> new ResourceNotFoundException("Refresh token not found!"));

        User user = refreshToken.getUser();

        if (isRefreshTokenExpired(refreshToken)) {
            refreshTokenRepository.delete(refreshToken);
            throw new UnauthorizedException("Refresh Token Expired!");
        }

        refreshTokenRepository.delete(refreshToken);

        return LoginResponse.builder()
                .accessToken(jwtUtils.generate(user.getUsername()))
                .refreshToken(generateRefreshToken(user))
                .build();

    }

    private RefreshToken generateCompleteNewRefreshToken(User user) {
        return refreshTokenRepository.save(
                RefreshToken.builder()
                        .refreshToken(UUID.randomUUID().toString())
                        .user(user)
                        .expirityDate(new Date(System.currentTimeMillis() +
                                1000 * 60 * 60 * jwt_refresh_token_expiration_in_hours))
                        .build()
        );
    }


    private boolean isRefreshTokenExpired(RefreshToken refreshToken) {
        return refreshToken.getExpirityDate().before(new Date());
    }
}
