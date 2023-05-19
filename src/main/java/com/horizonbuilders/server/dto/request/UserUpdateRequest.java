package com.horizonbuilders.server.dto.request;

public record UserUpdateRequest(
        String firstName,
        String lastName,
        String phoneNumber,
        String address
) {
}
