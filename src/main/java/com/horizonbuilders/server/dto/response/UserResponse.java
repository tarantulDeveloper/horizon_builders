package com.horizonbuilders.server.dto.response;

import com.horizonbuilders.server.model.enums.ERole;

import java.util.List;

public record UserResponse(
        String username,
        List<String> roles
) {
}
