package com.horizonbuilders.server.dto.request;

public record UserUpdateRequest(
        int id,
        String firstName,
        String lastName,
        String phoneNumber,
        String address
) {
}
