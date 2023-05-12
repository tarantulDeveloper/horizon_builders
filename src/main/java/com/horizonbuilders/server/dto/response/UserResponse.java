package com.horizonbuilders.server.dto.response;

import java.util.List;

public record UserResponse(
        String username,
        List<String> roles
) {
}
