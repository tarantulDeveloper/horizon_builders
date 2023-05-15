package com.horizonbuilders.server.dto.request;

public record UserPasswordUpdateRequest(
        int userId,
        String password
) {
}
