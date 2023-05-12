package com.horizonbuilders.server.dto.request;

public record UserRequest(
        String username,
        String password
) {
}
