package com.horizonbuilders.server.dto.request;

public record UserRequest(
        int positionId,
        String username,
        String password
) {
}
