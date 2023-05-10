package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse authenticate(String username, String password);
}
