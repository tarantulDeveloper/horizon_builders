package com.horizonbuilders.server.dto.request;

public record LoginRequest(
        String username,
        String password
) {
}
